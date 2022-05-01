
// Implémenter ici les 4 classes du modèle.
// N'oubliez pas l'héritage !

function Drawing() {
    this.tab=new Map();
}

function Forme(debX, debY,epaisseur,color) {
    this.debX=debX
    this.debY=debY
    this.epaisseur=epaisseur
    this.color=color
}
function Rectangle(debX,debY,epaisseur,color,height,width) {
    Forme.call(this,debX,debY,epaisseur,color)
    this.height=height
    this.width=width
}

function Line(debX,debY,epaisseur,couleur,finX,finY) {
    Forme.call(this,debX,debY,epaisseur,couleur)
    this.finX=finX
    this.finY=finY

}


