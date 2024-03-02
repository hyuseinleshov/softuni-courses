package entities.P05BillsPaymentSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Column
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetails {

    @Column
    private String name;

    @Column(name = "swift_code")
    private String swiftCode;
}
