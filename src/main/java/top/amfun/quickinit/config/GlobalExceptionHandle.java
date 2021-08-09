package top.amfun.quickinit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.common.exception.BusinessException;
import top.amfun.quickinit.common.exception.CommonErrorMessageEnum;
import top.amfun.quickinit.common.exception.SystemException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public RestResponse handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error(String.format("RemoteHost:%s,uri:%s,code:%s,msg:%s", request.getRemoteHost(), request.getRequestURI(), e.getCode(), e.getMessage()));
        return RestResponse.fail(e.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public RestResponse handleSystemException(SystemException e, HttpServletRequest request) {
        log.error(String.format("RemoteHost:%s,uri:%s,code:%s,msg:%s", request.getRemoteHost(), request.getRequestURI(), e.getCode(), e.getMessage()));
        return RestResponse.fail(e.getCode(), e.getMessage());
    }

    /**
     * @RequestParam的参数校验
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public RestResponse missingServletRequestParameterException(SystemException e, HttpServletRequest request) {
        SystemException ex = CommonErrorMessageEnum.DEFAULT.systemException("@RequestParam的参数校验失败: " + e.getMessage());
        log.error(String.format("RemoteHost:%s,uri:%s,code:%s,msg:%s", request.getRemoteHost(), request.getRequestURI(), e.getCode(), e.getMessage()));
        return RestResponse.fail(ex.getCode(), ex.getMessage());
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public void handleJacksonException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.error(String.format("RemoteHost:%s,uri:%s", request.getRemoteHost(), request.getRequestURI()), ex);
    }

    /*
     * BindException和MethodArgumentNotValidException不能放到一起写，
     * 否侧不会给前端返回明确的异常提示
     */
    /**
     * 处理@Valid的参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    public RestResponse<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        SystemException ex = CommonErrorMessageEnum.DEFAULT.systemException("参数校验失败: " + objectError.getDefaultMessage());
        return RestResponse.fail(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理参数校验异常
     * @param
     * @return
     */
    @ExceptionHandler(value = {BindException.class})
    @ResponseBody
    public RestResponse<String> bindExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        SystemException ex = CommonErrorMessageEnum.DEFAULT.systemException("参数校验失败: " + objectError.getDefaultMessage());
        return RestResponse.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public ResponseEntity<RestResponse> handleException(Exception e, HttpServletRequest request) {

        if(e instanceof HttpRequestMethodNotSupportedException){
            return new ResponseEntity(RestResponse.fail(405, "method 方法不支持"), HttpStatus.METHOD_NOT_ALLOWED);

        }else if(e instanceof HttpMediaTypeNotSupportedException){
            return new ResponseEntity(RestResponse.fail(415, "不支持媒体类型"), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }else if(e instanceof AccessDeniedException){
            return new ResponseEntity(RestResponse.fail(403, "无权限访问"), HttpStatus.FORBIDDEN);
        }

        log.error(String.format("RemoteHost:%s,uri:%s", request.getRemoteHost(), request.getRequestURI()), e);
        BusinessException ex = CommonErrorMessageEnum.DEFAULT.unknownException();
        return new ResponseEntity(RestResponse.fail(ex.getCode(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
