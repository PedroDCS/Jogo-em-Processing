void mouse ()
{
PFont f;
  fill(0);
  f = createFont("Arial", 15);
  textFont(f);
//  text("mouseX = " + mouseX, 10, 20);
//  text("mouseY =" + mouseY, 10, 60);
}


void movepudim()
{
xpudim = xpudim - 18;

}

void mexepersonagemesp()
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
    
  
    fundo.amp(1.0);
    esp.amp(0.0);
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
void comerespecial()
{
  if (xpudim+28 <= xdinoesp+170 && xpudim+28 >= xdinoesp+100 &&  ydinoesp+55 <=  ypudim +60 && ydinoesp+145 >=   ypudim +80)
  {
    pontos = pontos + 5;
    xpudim = 1200;
    ypudim = random(1, 470);
  }

}
void comerbolinho()
{
  if (xbolinho+30 >= xdino+20 && xbolinho <=xdino+140 && ybolinho+50 >= ydino2+63 && ybolinho+50 <= ydino2+100 )
  {
    clear();
    xbolacha = random (0, 1100);
    ybolachadesce = -29;
    esp.amp(1.0);
    fundo.amp(0.0);
    
    
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

    fundo.amp(0.0);
    esp.amp(1.0);
    
    bolin = true;
    
    velbolachadece = 0;
    velbolinho = 0;
    veldino = 0;
   

    jogoespecial();
  }
}


















void mexepersonagem()
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


void velocidade ()
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





void clicarnobotao1()
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

void clicarnobotao2()
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
void clicarnobotao3()
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


void mexerBolachasobe()
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



void cairbolacha()
{
  ybolachadesce = ybolachadesce + velbolachadece;
  if (ybolachadesce >=  600)
  {
    ybolachadesce = -29;
    xbolacha = random (0, 1100);
  }
  
}


void comer()
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
    perdeu.amp(1.0);
    perdeu.loop();
    fill(#FC7303);
    textAlign(LEFT, CENTER);
    textFont(novojogo);
    text("Novo Jogo", 400, 200);
    text("Sair do Jogo", 360, 300);
  }
}

void mousePressed()
{

  if (perder == true && mouseX >=400 && mouseX <=779 && mouseY >=180 && mouseY <=230)
  {
    clear();
    pontos = 0;
    jogo();
    perdeu.stop();
    perdeu.amp(0.0);
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

void mexernuvem()
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