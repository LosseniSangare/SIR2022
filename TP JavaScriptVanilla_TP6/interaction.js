
// La création d'un Dnd requière un canvas et un interacteur.
// L'interacteur viendra dans un second temps donc ne vous en souciez pas au départ.
function DnD(canvas, interactor) {
	// Définir ici les attributs de la 'classe'
  this.debX=0;
  this.debY=0;
  this.finX=0;
  this.finY=0;
  this.isClicked=false;
  this.interactor=interactor
  
	// Developper les 3 fonctions gérant les événements
  this.clicMouse=function(evt){
    var mousePos=getMousePosition(canvas, evt);
    this.debX=mousePos.x;
    this.debY=mousePos.y;
    this.isClicked=true;
    //console.log(mousePos);
    this.interactor.onInteractionStart(this);

  }.bind(this);

  this.moveMouse=function(evt){
    if(this.isClicked){
      var mousePos=getMousePosition(canvas,evt);
      this.finX=mousePos.x;
      this.finY=mousePos.y;
      this.isClicked=true;
      //console.log(mousePos);
      this.interactor.onInteractionUpdate(this);

    }

  }.bind(this);

  this.releaseMouse=function(evt){
    var mousePos=getMousePosition(canvas,evt);
    this.finX=mousePos.x;
    this.finY=mousePos.y;
    this.isClicked=false;
   // console.log(mousePos);
    this.interactor.onInteractionEnd(this);



  }.bind(this);

  canvas.addEventListener('mousedown', this.clicMouse, false);
  canvas.addEventListener('mousemove', this.moveMouse, false);
  canvas.addEventListener('mouseup', this.releaseMouse, false);

	// Associer les fonctions précédentes aux évènements du canvas.

};


// Place le point de l'événement evt relativement à la position du canvas.
function getMousePosition(canvas, evt) {
  var rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  };
};



