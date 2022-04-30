public class Buyer {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
        if (!firstName.matches("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]+(?: [\\p{L}\\p{M},.'-]+)*$")){
            throw new InvalidNameException("Неправильно введене ім'я");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidNameException {
        if (!lastName.matches("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]+(?: [\\p{L}\\p{M},.'-]+)*$")){
            throw new InvalidNameException("Неправильно введене прізвище");
        }
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws InvalidNameException {
        if (!patronymic.matches("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]+(?: [\\p{L}\\p{M},.'-]+)*$")){
            throw new InvalidNameException("Неправильно введено по батькові");
        }
        this.patronymic = patronymic;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) throws InvalidCardNumberException {
        if (!cardNumber.matches("^[0-9]{16}$")){
            throw new InvalidCardNumberException("Неправильно введено номер карти");
        }
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (!accountNumber.matches("^[0-9]{20}$")){
            throw new InvalidAccountNumberException("Неправильно введено номер рахунку");
        }
        this.accountNumber = accountNumber;
    }

    public Buyer(String firstName, String lastName, String patronymic, String cardNumber, String accountNumber)
            throws InvalidNameException, InvalidCardNumberException, InvalidAccountNumberException{
        setFirstName(firstName);
        setLastName(lastName);
        setPatronymic(patronymic);
        setCardNumber(cardNumber);
        setAccountNumber(accountNumber);
    }

    private String firstName;
    private String lastName;
    private String patronymic;
    private String cardNumber;
    private String accountNumber;
    @Override
    public String toString(){
        return "Прізвище: "+getLastName()+"\tІм'я: "+getFirstName()+"\tНомер карти: "+getCardNumber();
    }
}
