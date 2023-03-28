package br.seeddesafiocdc.advice;

import br.seeddesafiocdc.dto.ErroValidacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExcecaoAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroValidacaoDto trataExcecaoValidacao(MethodArgumentNotValidException exception) {
        return new ErroValidacaoDto(mapErrors(exception));
    }


    private List<String> mapErrors(MethodArgumentNotValidException exception) {

        List<String> mensagens = new ArrayList<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            mensagens.add(String.format("%s %s",
                    error.getField(),
                    messageSource.getMessage(error, LocaleContextHolder.getLocale())));
        }

        return mensagens;
    }

}
