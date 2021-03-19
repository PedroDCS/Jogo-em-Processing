void inicio()
{
  if (inicializar <= 10)
  {
    image(dino, 0, 0, 1166, 568 );
    dino.play();
    x = x+1;
    if (x>=50)
    {
     
      
      menu.amp(1.0);
      stroke(#FC0D0D);
      noFill();
      image (inicio, 0, 0, 1166, 568);

      fill(#FC7303);
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

void movieEvent(Movie m) {
  m.read();
}



void Cenario ()
{
  clear();
  image (ceu, 0, 0, 1166, 568);
  image (nuvem, xnuvem1, ynuvem1, 250, 250); 
  image (nuvem2, xnuvem2, ynuvem2, 250, 250); 
  image (nuvem3, xnuvem3, ynuvem3, 250, 250); 
  image (nuvem4, xnuvem4, ynuvem4, 250, 250); 
  image (vaco, 970, 500, 114, 60);
  image (bolacha, 526, ybolachasobe, 90, 50);
  fundo.amp(1.0);
  perdeu.stop();
  perdeu.amp(0.0);
}

void especial ()
{
 image (especial, 0, 0);
 image (cat,xpudim,ypudim);
 image (arcoiris,xdinoesp-1253,ydinoesp);
 image (dinoespecial , xdinoesp,ydinoesp,200,165);

  
  
}

void Personagem()
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

void comida ()
{
  image (bolacha1, xbolacha, ybolachadesce, 70, 69);
  image (bolinho, xbolinho,ybolinho,50,50);
}

void Pontos()
{


  fill(#050000);
  textAlign(LEFT, CENTER);
  textFont(ponto);
  text("Pontuação: " + pontos, 950, 18);
}

void creditos()
{
  
  image(credito,0,0,1166, 568);
}