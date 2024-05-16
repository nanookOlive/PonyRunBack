package test

import java.util.*


class Sortie {

    private var id : Int ;
    private var date : Date;
    private var nbKilometres : Float;
    private var duree : Int;
    private var avis : String;


    constructor(id : Int, date : Date, nbKilometres : Float, duree : Int, avis : String){
        this.id=id;
        this.date=date;
        this.nbKilometres=nbKilometres;
        this.duree=duree;
        this.avis=avis;
    }

    public fun getId():Int{
        return this.id;
    }

    public fun getDate():Date{
        return this.date;
    }
    public fun getNbKilometres():Float{
        return this.nbKilometres;
    }
    public fun getDuree():Int{
        return this.duree;
    }
    public fun getAvis():String{
        return this.avis;
    }
    public fun setId(id : Int){
        this.id=id;
    }
    public fun setDate(date : Date) {
        this.date = date;
    }

    public fun setNbKilometres(nbKilometres : Float){
        this.nbKilometres=nbKilometres;
    }
    public fun setDuree(duree : Int) {
        this.duree = duree;
    }
    public fun setAvis(avis: String){
        this.avis=avis;
    }

}
