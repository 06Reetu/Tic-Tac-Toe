package com.project; 
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.Font; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; import javax.swing.SwingConstants; 
public class Game extends JFrame implementsActionListener{
11 
JLabel heading,footer; 
Font font=new Font("" 
,Font.BOLD,40); 
JPanel mainPanel; 
JButton []btns=new JButton[9]; 
//game variable 
int gameChances[]={2,2,2,2,2,2,2,2,2}; int activePlayer=0; 
int wps[][] ={ 
{0 , 1, 2}, 
{3, 4, 5}, 
{6, 7, 8}, 
{0, 3, 6}, 
{1, 4, 7}, 
{2, 5, 8}, 
{0, 4, 8}, 
{2, 4, 6} 
}; 
int winner=2; 
Game(){ 
System.out.println("My Game"); setTitle("Tic-Tac-Toe"); 
setSize(750,750); 
ImageIcon icon=new ImageIcon("src/img/TTT.png"); setIconImage(icon.getImage());
12 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
createGUI(); 
setVisible(true); 
} 
private void createGUI() 
{ this.getContentPane().setBackground(Color.decode("#202020")); 
this.setLayout(new BorderLayout()); 
heading=new JLabel("TIC-TAC-TOE"); heading.setIcon(new ImageIcon("src/img/TTT.png")); heading.setFont(font); 
heading.setHorizontalAlignment(SwingConstants.CENTER); 
heading.setForeground(Color.GRAY); this.add(heading,BorderLayout.NORTH); 
footer=new JLabel("Project By Group19"); footer.setFont(font); 
footer.setHorizontalAlignment(SwingConstants.CENTER); 
footer.setForeground(Color.GRAY); this.add(footer,BorderLayout.SOUTH);
13 
//panel 
mainPanel=new JPanel(); mainPanel.setLayout(newGridLayout(3,3));
for (int i=1 ; i <= 9; i++) { 
JButton btn=new JButton(); 
btn.setBackground(Color.decode("#000000"));btn.setFont(font); 
mainPanel.add(btn); 
btns[i-1] = btn; 
btn.addActionListener(this); 
btn.setName(String.valueOf(i-1)); 
} 
this.add(mainPanel,BorderLayout.CENTER);} 
@Override 
public void actionPerformed(ActionEvent e){JButton currentButton = (JButton)e.getSource(); 
String nameStr = currentButton.getName();int name=Integer.parseInt(nameStr.trim());
14 
if(gameChances[name]==2) 
{ 
if(activePlayer==1) 
{ 
currentButton.setIcon(new
ImageIcon("src/img/X.png")); 
gameChances [name]= activePlayer; activePlayer=0; 
} 
else 
{ 
currentButton.setIcon(new
ImageIcon("src/img/O.png")); 
gameChances [name]= activePlayer; activePlayer=1; 
} 
for(int []temp:wps) 
{ 
if((gameChances[temp[0]]==gameChances[temp[1]])&&(gameChances[temp[1]]==gameChances[temp[2]])&&gameChances[temp[2]]!=2) { 
winner=gameChances[temp[0]]; 
JOptionPane.showMessageDialog(null,"Player"+winner + "won the game."); 
int i = 
JOptionPane.showConfirmDialog(this,"Doyouwant to Play again?");
15 
if(i==0) 
{ 
this.setVisible(false); 
new Game(); 
} 
else if(i==1) 
{ 
System.exit(4321); 
} 
else 
{ 
} 
System.out.println(i); 
break; 
} 
} 
} 
else 
{ 
JOptionPane.showMessageDialog(this, "Position Already Occupied..."); } 
} 
}
