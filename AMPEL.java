
public class AMPEL
{
    private String ampelphase;

    private KREIS oben;
    private KREIS mitte;
    private KREIS unten;
    private RECHTECK gehaeuse;
    private RECHTECK rand;
    private RECHTECK stange;

    /**
     * BALL Konstruktor erzeugt eine neue Ampel
     */
    public AMPEL(String ausrichtung, String startphase)
    {

        this.ampelphase = startphase;
        this.stange = new RECHTECK(0.2,2);
        this.stange.setzeFarbe("schwarz");
        this.stange.setzeEbenenposition(1);

        this.rand = new RECHTECK(1.1,3.1);
        this.rand.setzeFarbe("schwarz");
        this.rand.setzeEbenenposition(1);

        this.gehaeuse = new RECHTECK(1,3);
        this.gehaeuse.setzeFarbe("dunkelgrau");
        this.gehaeuse.setzeEbenenposition(2);

        this.oben = new KREIS(0.3);
        this.oben.setzeFarbe("schwarz");
        this.oben.setzeEbenenposition(3);

        this.mitte = new KREIS(0.3);
        this.mitte.setzeFarbe("schwarz");
        this.mitte.setzeEbenenposition(3);

        this.unten = new KREIS(0.3);
        this.unten.setzeFarbe("schwarz");
        this.unten.setzeEbenenposition(3);

        if(ausrichtung == "sueden"){
            this.stange.setzeMittelpunkt(0, -2);
            this.rand.setzeMittelpunkt(0,0);
            this.gehaeuse.setzeMittelpunkt(0,0);
            this.oben.setzeMittelpunkt(0,1);
            this.mitte.setzeMittelpunkt(0,0);
            this.unten.setzeMittelpunkt(0,-1);
        }
        else if(ausrichtung == "norden"){
            this.stange.setzeMittelpunkt(0, 2);
            this.rand.setzeMittelpunkt(0,0);
            this.gehaeuse.setzeMittelpunkt(0,0);
            this.oben.setzeMittelpunkt(0,1);
            this.mitte.setzeMittelpunkt(0,0);
            this.unten.setzeMittelpunkt(0,-1);
        }
        else if(ausrichtung == "westen"){
            this.stange.setzeMittelpunkt(-2, 0);
            this.stange.drehenUm(90);
            this.rand.setzeMittelpunkt(0,0);
            this.rand.drehenUm(90);
            this.gehaeuse.setzeMittelpunkt(0,0);
            this.gehaeuse.drehenUm(90);
            this.oben.setzeMittelpunkt(1,0);
            this.mitte.setzeMittelpunkt(0,0);
            this.unten.setzeMittelpunkt(-1,0);
        }
        else if(ausrichtung == "osten"){
            this.stange.setzeMittelpunkt(2, 0);
            this.stange.drehenUm(90);
            this.rand.setzeMittelpunkt(0,0);
            this.rand.drehenUm(90);
            this.gehaeuse.setzeMittelpunkt(0,0);
            this.gehaeuse.drehenUm(90);
            this.oben.setzeMittelpunkt(-1,0);
            this.mitte.setzeMittelpunkt(0,0);
            this.unten.setzeMittelpunkt(1,0);
        }

        if(ampelphase == "gelb"){
            this.schalteAufGelb();
        }
        else if(ampelphase == "rot"){
            this.schalteAufRot();
        }
        else if(ampelphase == "rotgelb"){
            this.schalteAufRotGelb();
        }
        else if(ampelphase == "grün"){
            this.schalteAufGruen();
        }
        else if(ampelphase == "aus"){
            this.schalteAus();
        }
    }

    public void schalteAufRot(){
        oben.setzeFarbe("rot");
        mitte.setzeFarbe("schwarz");
        unten.setzeFarbe("schwarz");
        this.ampelphase = "rot";
    }

    public void schalteAufGelb(){
        oben.setzeFarbe("schwarz");
        mitte.setzeFarbe("gelb");
        unten.setzeFarbe("schwarz");
        this.ampelphase = "gelb";
    }

    public void schalteAufGruen(){
        oben.setzeFarbe("schwarz");
        mitte.setzeFarbe("schwarz");
        unten.setzeFarbe("grün");
        this.ampelphase = "gruen";
    }

    public void schalteAufRotGelb(){
        oben.setzeFarbe("rot");
        mitte.setzeFarbe("gelb");
        unten.setzeFarbe("schwarz");
        this.ampelphase = "rotgelb";
    }

    public void schalteAus(){
        oben.setzeFarbe("schwarz");
        mitte.setzeFarbe("schwarz");
        unten.setzeFarbe("schwarz");
        this.ampelphase = "aus";
    }

    public void verschiebeUm(double x, double y){
        stange.verschiebenUm(x,y);
        gehaeuse.verschiebenUm(x,y);
        oben.verschiebenUm(x,y);
        mitte.verschiebenUm(x,y);
        unten.verschiebenUm(x,y);
        rand.verschiebenUm(x,y);
    }

    public void weiterschalten(){
        if(this.ampelphase == "rot"){
            this.schalteAufRotGelb();
        }
        else if(this.ampelphase == "rotgelb"){
            this.schalteAufGruen();
        }
        else if(this.ampelphase == "gruen"){
            this.schalteAufGelb();
        }
        else if(this.ampelphase == "gelb"){
            this.schalteAufRot();
        }       
    }

}
