package se032;

import java.util.Locale;
import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {
		Questions q = new Questions(Locale.getDefault());

		Scanner ioS = new Scanner(System.in);
		boolean notEnd = true;

		do {
			System.out.println("1. Russian; 2. English; 3. Exit");
			switch (ioS.nextInt()) {
			case 1: {
				q.choseLanguage(true);
				do {
					System.out.println("1. Показать вопросы; 2. Показать ответ; 3 Сменить язык.");
					switch (ioS.nextInt()) {
					case 1: {
						q.showAllQuestion();
						break;						
					}
					case 2: {
						q.showAnswer(ioS.nextInt());
						break;
					}
					case 3: {
						notEnd = false;
						break;
					}
					default: {
						System.err.println("error");
						break;
					}
					}
				} while (notEnd);
				notEnd = true;
				break;
			}
			case 2: {
				q.choseLanguage(false);
				do {
					System.out.println("1. Show Questions; 2. Show Answer; 3 Other Language.");
					switch (ioS.nextInt()) {
					case 1: {
						q.showAllQuestion();
						break;
					}
					case 2: {
						q.showAnswer(ioS.nextInt());

						break;
					}
					case 3: {
						notEnd = false;
						break;
					}
					default: {
						System.err.println("error");
					}
					}
				} while (notEnd);
				notEnd = true;
				break;
			}
			case 3: {
				notEnd = false;
				break;
			}
			default: {
				System.err.println("error");
				break;
			}
			}
		} while (notEnd);
		ioS.close();
	}
}
