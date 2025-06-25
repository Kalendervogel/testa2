import com.sun.jna.*;
import com.sun.jna.ptr.*; //Importe für z.B. die Library Klasse

public class Bluescreen {
    public interface ntdll extends Library{ //Interface, um mit dem System zu interagieren
        ntdll INSTANCE = Native.load("ntdll",ntdll.class); //Lädt Klassen von ntdll.dll (aus System32)

        int RtlAdjustPrivilege(int Privilege, boolean bEnablePrivilege, boolean IsThreadPrivilege, IntByReference PreviousValue); //Rechte im System verändern
        int NtRaiseHardError(int ErrorStatus, int NumberOfParameters, int UnicodeStringParameterMask, Pointer Parameters, int ValidResponseOption, IntByReference Response); //Schweren Fehler verursachen
    }

    public static void dasEnde(){ //Erzeugt sofort einen Bluescreen
        try {
        IntByReference vohrherigerWert = new IntByReference(); //Integer wert der durch eine Methode verändert werden kann
        ntdll.INSTANCE.RtlAdjustPrivilege(19, true, false, vohrherigerWert); //Das Herunterfahren erlauben (Code 19)
        IntByReference antwort = new IntByReference();
        ntdll.INSTANCE.NtRaiseHardError(0xC0000022,0,0,null,6,antwort); //Erzeugt den Fehler / Bluescreen
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}