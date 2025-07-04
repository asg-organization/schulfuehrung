
public class KREUZUNG
{

    private AMPEL ampel_norden;
    private AMPEL ampel_sueden;
    private AMPEL ampel_westen;
    private AMPEL ampel_osten;
    private FIGUR hintergrund;

    public KREUZUNG()
    {
        this.hintergrund = new FIGUR("kreuzung.png");
        this.hintergrund.setzeMittelpunkt(0,0);
        this.hintergrund.setzeEbene(-1);

        ampel_norden = new AMPEL("norden","rot");
        ampel_sueden = new AMPEL("sueden","rot");
        ampel_westen = new AMPEL("westen","grün");
        ampel_osten = new AMPEL("osten","grün");

        ampel_norden.verschiebeUm(-4,4);
        ampel_sueden.verschiebeUm(4,-4);
        ampel_westen.verschiebeUm(-4,-4);
        ampel_osten.verschiebeUm(4,4);

    }

    public void weiterschalten(){
        ampel_norden.weiterschalten();
        ampel_sueden.weiterschalten();
        ampel_westen.weiterschalten();
        ampel_osten.weiterschalten();
    }

}
