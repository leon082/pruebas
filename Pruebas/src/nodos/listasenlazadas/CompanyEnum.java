package nodos.listasenlazadas;

import java.math.BigDecimal;

/**
 * The Enum CompanyEnum.
 */
public enum CompanyEnum {

    /**
     * The bancoomeva.
     */
    BANCOOMEVA(BigDecimal.ONE),
    /**
     * The coomeva.
     */
    COOMEVA(new BigDecimal(19));

    /**
     * The status.
     */
    private BigDecimal status;

    /**
     * Instantiates a new company enum.
     *
     * @param status the status
     */
    private CompanyEnum(BigDecimal status) {

        this.status = status;

    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public BigDecimal getStatus() {
       return status;
    }
}
