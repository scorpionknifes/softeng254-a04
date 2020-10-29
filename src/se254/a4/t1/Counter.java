package se254.a4.t1;

//This is an example (faulty) class to be used for A4 Task1 and Task2
public class Counter {
	public int _ctr;
	public int _multiplier;

	//method increments _ctr	
	public void increment() { 
		_ctr++; //increment		
	}
	
	//method decrements _ctr
	public void decrement() { 
		_ctr--; //decrement
	}
	
	//method resets _ctr
	public void reset() { 
		_ctr = 0; //reset, _ctr
	}
	
	//method multiplies _ctr by n
	public void multiplyBy(int multiplier) { 
		_multiplier = multiplier; //no fault here
		_ctr = _ctr * _multiplier; //no fault here
	}	
}
