package com.example.communication.advice;

import com.example.communication.exception.CustomizeErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomizeErrorException.class)
    @ResponseBody
    Object handleControllerException(HttpServletRequest request, CustomizeErrorException ex) {
        HttpStatus status = getStatus(request);
        if("application/json".equals(request.getHeader("content-type"))) {
            HashMap<Object, Object> resultMap = new HashMap<>();
            resultMap.put("retCode", ex.getCode());
            resultMap.put("retMsg", ex.getMessage());
            return resultMap;
        } else {
            ModelAndView error = new ModelAndView("error");
            error.addObject("message", ex.getMessage());
            return error;
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}