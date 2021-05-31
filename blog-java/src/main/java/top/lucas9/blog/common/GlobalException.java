package top.lucas9.blog.common;

import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lucas9.blog.entity.ResultEntity;

import java.io.IOException;

@RestControllerAdvice
public class GlobalException {

    /**
     * 捕捉 shiro 异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResultEntity handle401(ShiroException e) {
        return ResultEntity.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResultEntity handler(RuntimeException e) throws IOException {
        return ResultEntity.failed(e.getMessage());
    }

    /**
     * 捕获参数校验失败异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResultEntity handler(BindException e) {
        return ResultEntity.failed(e.getBindingResult().getFieldError().getDefaultMessage());

    }
    /**
     * 处理 Assert 校验失败异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultEntity handler(IllegalArgumentException e) throws IOException {
        return ResultEntity.failed(e.getMessage());
    }
}

