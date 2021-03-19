import processing.sound.*;

import processing.video.*;

PImage nuvem, dino1, dino2, ceu, vaco, nuvem2, nuvem3, nuvem4, inicio, bolacha, bolacha1,bolinho;
float xdino, ydino1, ydino2;
float x1ponto1dino, x2ponto1dino, y1ponto1dino, y2ponto1dino, x1ponto2dino, x2ponto2dino, y1ponto2dino, y2ponto2dino;
float xnuvem1, ynuvem1, xnuvem2, ynuvem2, xnuvem3, ynuvem3, xnuvem4, ynuvem4, velnuvem1, velnuvem2, velnuvem3, velnuvem4;
float x1linha1dino3, x2linha1dino3, x1linha2dino3, x2linha2dino3;
float ybolachasobe, ybolachadesce,velbolachadece, veldino,velbante,veldante;
float xbolacha, vel;
PFont algerian, ponto, novojogo;
int inicializar, pontos, x,y,pontosvel,pontosesp,velbolinho,q;
PImage especial, dinoespecial,credito,perde,arcoiris,cat;
float xdinoesp, veldinoesp,ydinoesp,velydinoesp,xpudim,ypudim,xbolinho,ybolinho,ypudim2;
boolean perder,bolin;
SoundFile fundo,perdeu,menu,esp;

Movie dino;


void setup()
{
  frameRate(70);
  size (1166, 568);
  bolin = false;
  
  bolinho = loadImage ("bolinho.png");
  especial = loadImage ("fundoespecial.png");
  dinoespecial = loadImage ("dinoespecial.png");
  cat = loadImage ("ncat.png");
   
   q = 5;
    xdinoesp = 0;
    veldinoesp = 10;
    ydinoesp = 238;
    velydinoesp = 40;
    xpudim = 1200;
    ypudim = random(1,490);
    xbolinho = random (0,1000);
    ybolinho = -100;
  
  
  
  
  
  credito=loadImage("creditos.png");
  ceu =loadImage ("fundo.PNG");
  perde=loadImage("perdeu.png");
  dino1 =loadImage ("personagem.png");
  dino2 = loadImage("personagem2.png");
  vaco = loadImage("vaco.png");
  nuvem = loadImage("nuvem2.PNG");
  nuvem2 = loadImage("nuvem1.PNG");
  nuvem3 = loadImage("nuvem3.PNG");
  nuvem4 = loadImage("nuvem4.PNG");
  inicio = loadImage("desnecessauro-4.png");
  bolacha = loadImage ("bolacha.png");
  bolacha1 = loadImage ("bolacha1.png");
  algerian = loadFont("Ravie-40.vlw");
  ponto = loadFont("Rockwell-Bold-25.vlw");
  arcoiris = loadImage ("cat.png");
  novojogo = loadFont("Ravie-60.vlw");
  perder = false;
  dino = new Movie(this, "dino.mp4");

  fundo = new SoundFile(this, "fundo.mp3");
  perdeu = new SoundFile(this, "perdeu.mp3");
  
  menu = new SoundFile(this, "menu.mp3");
  esp = new SoundFile(this, "Nyan.mp3");
  
 
  
  fundo.play();
  fundo.amp(0.0);

  
  esp.play();
  esp.amp(0.0);

  
  
  menu.play();

  menu.amp(0.0);
  
  
  velbolinho = 10;
  ybolachasobe = 162;  
 
  
  velbolachadece = 18;
  veldino = 55;
  velbante = 18;
  veldante = 55;


  xdino = 540;
  ydino1 = 1000;
  ydino2 = 341;

  xnuvem1 = random(-200, 1300);
  ynuvem1 =0;

  xnuvem2 = random(-200, 1300);
  ynuvem2 = 50;

  xnuvem3 = random(-200, 1300);
  ynuvem3 = 100;

  xnuvem4 = random(-200, 1300);
  ynuvem4 = -20;

  velnuvem1 = 3;
  velnuvem2 = 4;
  velnuvem3 = 6;
  velnuvem4 = 1;

  xbolacha = random (0, 1100);
  ybolachadesce = -29;

  inicializar = 5;

  
  
}

void draw()
{
  
  inicio();
  clicarnobotao1();
  clicarnobotao2();
  clicarnobotao3();
  mouse();
}

void jogo()
{

  Cenario (); 
  mexepersonagem();
  comida(); 
  Personagem();
  mexernuvem();
  mexerBolachasobe();
  cairbolacha();
  comer();
  comerbolinho();
  Pontos();
  mouse();
  velocidade ();

}

void jogoespecial()
{
 especial ();
 mexepersonagemesp();
 movepudim();
 comerespecial();
 Pontos();
 mouse();
  
}