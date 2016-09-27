package randomguess;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Random;

@SessionScoped
@Named
public class RandomGuess implements Serializable {
	
	final static long serialVersionUID = 1L;
	
	private int secretValue;
	private int guess;
	
	@PostConstruct
	public void initNewGuess(){
		System.out.println("constructing");
		setSecretValue(new Random().nextInt(10));
	}
	
	public int getGuess() {
		return guess;
	}
	
	public void setGuess(int guess) {
		this.guess = guess;
	}
	
	public void setSecretValue(int i){
		secretValue = i;
	}
	
	public String getSuccess(){
		System.out.println("in success checker. " + "guess: " + guess + " value: " + secretValue);
		if(guess == secretValue){
			return "Success!";
		}
		return "Fail!";
	}
}