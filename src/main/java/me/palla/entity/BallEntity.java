package me.palla.entity;

import me.palla.GiocoPalla;
import me.palla.util.ScaledResolution;
import me.palla.value.Value;

/*
@author Mattia Broch
@version 1.0
@brief classe per il disegno e il controllo della pallina 
*/
public class BallEntity implements Entity {
    /*
    @brief attributo di classe PhysicsThread, far� startare nella pallina il thread
    che permetter� la ripetizione di onTick() e onRender()
    */
    private PhysicsThread th;
    
    
    /*
    @brief attributo che definisce la coordinata X della pallina,
    verr� aggiornato da onTick()
    */
    private float xPos;
    /*
    @brief attributo che definisce la coordinata Y della pallina,
    verr� aggiornato da onTick()
    */
    private float yPos;
    /*
    @brief attributo che definisce il raggio della pallina
    */
    private float radius;
    /*
    @brief attributo che definisce la velocit� sull'asse X della pallina
    */
    private float xSpeed;
    /*
    @brief attributo che definisce la velocit� sull'asse Y della pallina
    */
    private float ySpeed;
    
    /*
    @brief costruttore della pallina, setta la posizione iniziale, il raggio,
    la velocit�, inizializza e starta il thread per onTick e onRender 
    */
    public BallEntity() {
        xPos = 100;
        yPos = 100;
        radius = 50;
        
        th = new PhysicsThread(this);
        th.start();
        
        xSpeed = 1f;
        ySpeed = 1f;
    }

    /*
    @brief metodo ripetuto continuamente che setta le nuove coordinate
    di X e Y della pallina in base alla velocit�
    */
    @Override
    public void onTick() {
        xPos+=xSpeed;
        yPos+=ySpeed;
    }
    
    /*
    @brief metodo ripetuto continuamente che ogni volta richiama il metodo per
    il disegno della pallina
    */
    @Override
    public void onRender() {
        draw(xPos,yPos,radius);
    }
    /*
    @brief metodo che disegna la pallina
    @param xPos la coordinata X della pallina
    @param yPos la coordinata Y della pallina
    @param radius il raggio della pallina
    */
    private void draw(float xPos,float yPos,float radius){
        GiocoPalla.getInstance().pushStyle();
        GiocoPalla.getInstance().fill(255,0,0);
        GiocoPalla.getInstance().ellipse(xPos,yPos,radius,radius);
        GiocoPalla.getInstance().popStyle();
    }
    
    /*
    @brief metodo che setta la velocit� sull'asse X della pallina
    @param rotationX la nuova velocit� sull'asse X della pallina
    */
    @Override
    public void rotateX(float rotationX) {
        //this.xSpeed = rotationX;
        
    }

    /*
    @brief metodo che setta la velocit� sull'asse Y della pallina
    @param rotationY la nuova velocit� sull'asse Y della pallina
    */
    @Override
    public void rotateY(float rotationY) {
        //this.ySpeed = rotationY;
    }
    
    
}
