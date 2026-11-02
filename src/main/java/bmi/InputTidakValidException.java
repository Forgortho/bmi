package bmi;


public class InputTidakValidException extends Exception {

    public InputTidakValidException(String pesan) {
        super(pesan);
    }

    public InputTidakValidException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }
}
