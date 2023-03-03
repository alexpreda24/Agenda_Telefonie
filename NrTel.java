public abstract class NrTel {
    private final String numar;

    public abstract void validareNumar(String numar) throws NrTelException;

    NrTel(String numar) throws NrTelException {
        validareNumar(numar);
        this.numar = numar;
    }

    public String getNumar() {

        System.out.println("Numarul este: " + numar);
        return numar;
    }
}

