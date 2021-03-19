import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 
import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Projeto extends PApplet {





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


public void setup()
{
  frameRate(70);
  
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
  fundo.amp(0.0f);

  
  esp.play();
  esp.amp(0.0f);

  
  
  menu.play();

  menu.amp(0.0f);
  
  
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

public void draw()
{
  
  inicio();
  clicarnobotao1();
  clicarnobotao2();
  clicarnobotao3();
  mouse();
}

public void jogo()
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

public void jogoespecial()
{
 especial ();
 mexepersonagemesp();
 movepudim();
 comerespecial();
 Pontos();
 mouse();
  
}
public void inicio()
{
  if (inicializar <= 10)
  {
    image(dino, 0, 0, 1166, 568 );
    dino.play();
    x = x+1;
    if (x>=50)
    {
     
      
      menu.amp(1.0f);
      stroke(0xffFC0D0D);
      noFill();
      image (inicio, 0, 0, 1166, 568);

      fill(0xffFC7303);
      textFont(algerian);
      text("Jogar", 194, 210);
      text("Sair", 194, 300);
    }
  } else
  {
    menu.stop();
    jogo();
  }
}

public void movieEvent(Movie m) {
  m.read();
}



public void Cenario ()
{
  clear();
  image (ceu, 0, 0, 1166, 568);
  image (nuvem, xnuvem1, ynuvem1, 250, 250); 
  image (nuvem2, xnuvem2, ynuvem2, 250, 250); 
  image (nuvem3, xnuvem3, ynuvem3, 250, 250); 
  image (nuvem4, xnuvem4, ynuvem4, 250, 250); 
  image (vaco, 970, 500, 114, 60);
  image (bolacha, 526, ybolachasobe, 90, 50);
  fundo.amp(1.0f);
  perdeu.stop();
  perdeu.amp(0.0f);
}

public void especial ()
{
 image (especial, 0, 0);
 image (cat,xpudim,ypudim);
 image (arcoiris,xdinoesp-1253,ydinoesp);
 image (dinoespecial , xdinoesp,ydinoesp,200,165);

  
  
}

public void Personagem()
{

  image (dino2, xdino, ydino2, 190, 206);
  image (dino1, xdino, ydino1, 190, 206);

  if (keyPressed && key==CODED) 
  {
    switch(keyCode) 
    {
    case LEFT:
      ydino1 = 1000;
      ydino2 = 341;

      break;

    case RIGHT:
      ydino2 = 1000;
      ydino1 =341;
      break;
    }
  }
}

public void comida ()
{
  image (bolacha1, xbolacha, ybolachadesce, 70, 69);
  image (bolinho, xbolinho,ybolinho,50,50);
}

public void Pontos()
{


  fill(0xff050000);
  textAlign(LEFT, CENTER);
  textFont(ponto);
  text("Pontua\u00e7\u00e3o: " + pontos, 950, 18);
}

public void creditos()
{
  
  image(credito,0,0,1166, 568);
}
public void mouse ()
{
PFont f;
  fill(0);
  f = createFont("Arial", 15);
  textFont(f);
//  text("mouseX = " + mouseX, 10, 20);
//  text("mouseY =" + mouseY, 10, 60);
}


public void movepudim()
{
xpudim = xpudim - 18;

}

public void mexepersonagemesp()
{
  if (keyPressed && key==CODED) 
  {
    switch(keyCode) 
    {
    case UP:
      ydinoesp = ydinoesp - velydinoesp;

      if (ydinoesp < -10 )
      {
        ydinoesp = -10;
      }
      break;
      
      case DOWN:
      ydinoesp = ydinoesp + velydinoesp;

      if (ydinoesp > 430 )
      {
        ydinoesp = 430;
      }
      break;
      
    }
  }
  xdinoesp = xdinoesp +13;
  
  if ( xdinoesp >=1166)
  {
    clear();
    
  
    fundo.amp(1.0f);
    esp.amp(0.0f);
    xdinoesp = 100;
    velbolachadece = velbante;
    veldino = veldante;
    ybolinho = -70;
    xbolinho = random (0,1000);
    bolin = false;
    //loop();
    xbolacha = random (0, 1100);
    ybolachadesce = -29;
    xpudim = 1200;
    ypudim = random(1,490);
     xdino = 540;
  ydino1 = 1000;
  ydino2 = 341;
    jogo();
    
    
  }
  
}
public void comerespecial()
{
  if (xpudim+28 <= xdinoesp+170 && xpudim+28 >= xdinoesp+100 &&  ydinoesp+55 <=  ypudim +60 && ydinoesp+145 >=   ypudim +80)
  {
    pontos = pontos + 5;
    xpudim = 1200;
    ypudim = random(1, 470);
  }

}
public void comerbolinho()
{
  if (xbolinho+30 >= xdino+20 && xbolinho <=xdino+140 && ybolinho+50 >= ydino2+63 && ybolinho+50 <= ydino2+100 )
  {
    clear();
    xbolacha = random (0, 1100);
    ybolachadesce = -29;
    esp.amp(1.0f);
    fundo.amp(0.0f);
    
    
    bolin = true;    
    
    velbolachadece = 0;
    velbolinho = 0;
    veldino = 0;
   
    
    jogoespecial();
  }
  if (xbolinho+40 >= xdino+30 && xbolinho+20 <=xdino+169 && ybolinho+50 >= ydino1+63 && ybolinho+50 <= ydino1+100)
  {
    clear();
    xbolacha = random (0, 1100);
    ybolachadesce = -29;

    fundo.amp(0.0f);
    esp.amp(1.0f);
    
    bolin = true;
    
    velbolachadece = 0;
    velbolinho = 0;
    veldino = 0;
   

    jogoespecial();
  }
}


















public void mexepersonagem()
{
  if (keyPressed && key==CODED) 
  {
    switch(keyCode) 
    {

    case LEFT:
      xdino = xdino - veldino;

      if (xdino < -10 )
      {
        xdino = -10;
      }
      break;


    case RIGHT:
      xdino = xdino + veldino;

      if (xdino > 990 )
      {


        xdino = 990;
      }
      break;
    }
  }
}


public void velocidade ()
{
 if (pontosvel ==10)
 {   
  velbante = velbante +2;
  veldante = veldante +2;
  velbolachadece = velbolachadece +2 ;
  veldino = veldino +2; 
  pontosvel = 0;
 }

}





public void clicarnobotao1()
{
  if (mousePressed) 
  {

    if ( (194 < mouseX) && (194+143 > mouseX) &&
      (180 < mouseY) && (213 > mouseY) ) 
    {

      inicializar = inicializar +10;
    }
  }
}

public void clicarnobotao2()
{
  if (mousePressed) 
  {

    if ( (194 < mouseX) && (194+143 > mouseX) &&
      (270 < mouseY) && (300 > mouseY) ) 
    {

      exit();
    }
  }
}
public void clicarnobotao3()
{
  if (mousePressed) 
  {

    if ( (941 < mouseX) && (1142 > mouseX) &&
      (12 < mouseY) && (42 > mouseY) ) 
    {

      creditos ();
    }
  }
}


public void mexerBolachasobe()
{
  ybolachasobe = ybolachasobe -25;
   
  if (ybolachasobe <= -50)
  {
    ybolachasobe = 162;
  }
  
  
  if (pontosesp >=10)
  {
    velbolinho = 10;
  ybolinho = ybolinho +velbolinho;
    if (ybolinho >600)
  {
    velbolinho = 0;
    pontosesp = 0;
    ybolinho = -100;
    xbolinho = random (0,1000);
  }
  if(bolin == true)
  {
  velbolinho = 0;
   pontosesp = 0;
  }
  
  
  }
  
}



public void cairbolacha()
{
  ybolachadesce = ybolachadesce + velbolachadece;
  if (ybolachadesce >=  600)
  {
    ybolachadesce = -29;
    xbolacha = random (0, 1100);
  }
  
}


public void comer()
{
  if (xbolacha+50 >= xdino+20 && xbolacha <=xdino+140 && ybolachadesce+66 >= ydino2+63 && ybolachadesce+66 <= ydino2+100 )
  {
    ybolachadesce = 599;
    pontos = pontos+1;
    pontosvel = pontosvel +1;
    pontosesp = pontosesp +1;
    perder = false;
  }
  if (xbolacha+50 >= xdino+30 && xbolacha+50 <=xdino+169 && ybolachadesce+66 >= ydino1+63 && ybolachadesce+66 <= ydino1+100)
  {
    ybolachadesce = 599;
    pontos = pontos+1;
    pontosvel = pontosvel +1;
    pontosesp = pontosesp +1;
    perder = false;
  }
  else if (ybolachadesce >=568 && ybolachadesce <= 598)
  {
    clear();
    image(perde,0,0);
    perder = true;  
    noLoop();
    fundo.stop();
    perdeu.amp(1.0f);
    perdeu.loop();
    fill(0xffFC7303);
    textAlign(LEFT, CENTER);
    textFont(novojogo);
    text("Novo Jogo", 400, 200);
    text("Sair do Jogo", 360, 300);
  }
}

public void mousePressed()
{

  if (perder == true && mouseX >=400 && mouseX <=779 && mouseY >=180 && mouseY <=230)
  {
    clear();
    pontos = 0;
    jogo();
    perdeu.stop();
    perdeu.amp(0.0f);
    fundo.play();
    velbolachadece = 18;
    veldino = 55;
    xdino = 540;
    ydino1 = 1000;
    ydino2 = 341;
    loop();
  }

  if (perder == true && mouseX >=400 && mouseX <=779 && mouseY >=280 && mouseY <=325)
  {
    exit();
  }
}

public void mexernuvem()
{
  // controla a nuvem 1
  xnuvem1 = xnuvem1 + velnuvem1;
  if (velnuvem1>0)
  {
    if (xnuvem1>=1200)
    {
      velnuvem1 = velnuvem1*(-1);
    }
  } else
  {
    if (xnuvem1 <=-250)
    {
      velnuvem1 = velnuvem1*(-1);
    }
  }


  //controla a nuvem 2

  xnuvem2 = xnuvem2 + velnuvem2;
  if (velnuvem2>0)
  {
    if (xnuvem2>=1350)
    {
      velnuvem2 = velnuvem2*(-1);
    }
  } else
  {
    if (xnuvem2 <=-250)
    {
      velnuvem2 = velnuvem2*(-1);
    }
  }

  //controla a nuvem 3

  xnuvem3 = xnuvem3 + velnuvem3;
  if (velnuvem3>0)
  {
    if (xnuvem3>=1350)
    {
      velnuvem3 = velnuvem3*(-1);
    }
  } else
  {
    if (xnuvem3 <=-250)
    {
      velnuvem3 = velnuvem3*(-1);
    }
  }


  //controla a nuvem 4

  xnuvem4 = xnuvem4 + velnuvem4;
  if (velnuvem4>0)
  {
    if (xnuvem4>=1350)
    {
      velnuvem4 = velnuvem4*(-1);
    }
  } else
  {
    if (xnuvem4 <=-250)
    {
      velnuvem4 = velnuvem4*(-1);
    }
  }
}
  public void settings() {  size (1166, 568); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Projeto" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
