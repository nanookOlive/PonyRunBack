package test



class Sortie {

    private var id : String? ;
    private var date : String?;
    private var nbKilometres : String?;
    private var duree : String?;
    private var avis : String?;



    constructor(id : String?, date : String?, nbKilometres : String?, duree :String?, avis : String?){
        this.id=id;
        this.date=date;
        this.nbKilometres=nbKilometres;
        this.duree=duree;
        this.avis=avis;
    }

    public fun getId():String?{
        return this.id;
    }

    public fun getDate():String?{
        return this.date;
    }
    public fun getNbKilometres():String?{
        return this.nbKilometres;
    }
    public fun getDuree():String?{
        return this.duree;
    }
    public fun getAvis():String?{
        return this.avis;
    }
    public fun setId(id : String){
        this.id=id;
    }
    public fun setDate(date : String) {
        this.date = date;
    }

    public fun setNbKilometres(nbKilometres : String){
        this.nbKilometres=nbKilometres;
    }
    public fun setDuree(duree :String) {
        this.duree = duree;
    }
    public fun setAvis(avis: String){
        this.avis=avis;
    }

}
