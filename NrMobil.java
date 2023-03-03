public class NrMobil extends NrTel {
    @Override
    public void validareNumar(String numar) throws NrTelException{
        if(numar.length() != 10 && !numar.substring(0,2).equals("07")){
            throw new NrTelException("Nr Mobil nu este valid");
        }
    }
       public NrMobil(String numar) throws NrTelException {
           super(numar);
    }


}
