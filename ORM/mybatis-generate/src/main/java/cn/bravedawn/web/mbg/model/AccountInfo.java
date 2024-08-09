package cn.bravedawn.web.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class AccountInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账户号
     */
    private String accountNo;

    /**
     * 业务日期
     */
    private Date bizDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", bizDate=").append(bizDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}