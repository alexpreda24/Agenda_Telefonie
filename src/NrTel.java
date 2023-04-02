public abstract class NrTel {
    private String numar;

    public abstract void validareNumar(String numar) throws NrTelException;

    NrTel(String numar) throws NrTelException {
        validareNumar(numar);
        this.numar = numar;
    }

    public String getNumar() {

        System.out.println("Numarul este: " + numar);
        return numar;
    }

    public void setNumar(String numar) throws NrTelException {
        validareNumar(numar);
        this.numar = numar;
    }
}

