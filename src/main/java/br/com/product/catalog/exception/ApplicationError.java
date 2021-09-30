package br.com.product.catalog.exception;

import br.com.shopping.cart.commons.shopping.cart.commons.model.BaseApplicationError;
import org.springframework.http.HttpStatus;

import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ApplicationError implements BaseApplicationError {

    PCA_PRODUCT_NOT_FOUND ("001", NOT_FOUND, TRUE, "Produto não encontrado para o id: {}");

    private final String code;
    private final String description;
    private final HttpStatus httpStatus;
    private final boolean acceptParameters;

    ApplicationError(String code, HttpStatus httpStatus, boolean acceptParameters, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
        this.acceptParameters = acceptParameters;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean getAcceptParameters() {
        return acceptParameters;
    }
}
