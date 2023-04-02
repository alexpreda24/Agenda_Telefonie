public class NrFix extends NrTel {
    @Override
    public void validareNumar(String numar) throws NrTelException{
        if(numar.length() != 10 && (!numar.substring(0,2).equals("02") || !numar.substring(0,2).equals("03"))){
            throw new NrTelException("Nr Fix nu este valid");
        }
    }

    private String numarTelMobil;
    public NrFix(String numar) throws NrTelException {
        super(numar);
    }
}
