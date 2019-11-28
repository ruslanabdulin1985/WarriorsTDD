import controller.Control;
import model.Fight;
import model.Part;
import model.Warrior;
import view.Console;

public class program {

	public static void main(String[] args) {
		Control ctrl = new Control();
		Warrior player = new Warrior(new Part(10), new Part(10), new Part(10), new Part(10), new Part(10), new Part(10));
		Warrior enemy = new Warrior(new Part(10), new Part(10), new Part(10), new Part(10), new Part(10), new Part(10));
		Fight game = new Fight(player, enemy);
		Console con = new Console();
		while(true) {
			ctrl.run(game, con);
		}

	}

}
