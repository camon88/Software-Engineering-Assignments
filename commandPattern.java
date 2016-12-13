public class TV {
	String location;
	int channel;

	public TV(String location) {
		this.location = location;
		this.channel = 0;
	}

	public void on() {
		System.out.println("TV is on");
	}

	public void off() {
		System.out.println("TV is off");
	}
	
	public void up() {
		channel++;
		System.out.println("TV channel changed to " + channel);
	}
	
	public void down() {
		channel = (channel > 0 ? channel - 1 : channel);
		System.out.println("TV channel changed to " + channel);
	}

	public void setInputChannel() {
		this.channel = 3;
		System.out.println("Channel is set for VCR");
	}
}

class TVUpCommand implements Command {
	private TV receiver;
	
	public TVUpCommand(TV tv) {
		this.receiver = tv;
	}

	public void execute() {
		receiver.up();
	}
}

class TVDownCommand implements Command {
	private TV receiver;
	
	public TVDownCommand(TV tv) {
		this.receiver = tv;
	}
	
	public void execute() {
		receiver.down();
	}
}

class TVOffCommand implements Command {
	private TV receiver;

	public TVOffCommand(TV tv) {
		this.receiver = tv;
	}
	
	public void execute() {
		receiver.off();
	}
}

class TVOnCommand implements Command {
	private TV receiver;
	
	public TVOnCommand(TV tv) {
		this.receiver = tv;
	}
	
	public void execute() {
		receiver.on();
	}
}


class RemoteLoader {
 
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
 
		TV tv = new TV("Living Room");
		
		TVOnCommand livingRoomTVOn = new TVOnCommand(tv);
		TVOffCommand livingRoomTVOff = new TVOffCommand(tv);
		TVUpCommand livingRoomTVUp = new TVUpCommand(tv);
		TVDownCommand livingRoomTVDown = new TVDownCommand(tv);
		
		remoteControl.setCommand(4, livingRoomTVOn, livingRoomTVOff);
		remoteControl.setCommand(5, livingRoomTVUp, livingRoomTVDown);
		
		System.out.println(remoteControl);
 
		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);
		remoteControl.onButtonWasPushed(5);
		remoteControl.offButtonWasPushed(5);
	}
}


