package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 * 
 * PHP用Paizaデバッグツール
 * （コマンドプロンプト（バッチファイル）でphp実行してログファイル出力）
 * ログファイルとテストケース解答を比較する
 * 
 * @author mgmg-zbtn
 * @since 2023/09/25
 */
public class PaizaCompare {

	public static void main(String[] args) throws IOException {
		
		Path logPath = Paths.get(args[0]);
		Path ansPath = Paths.get(args[1]);
		
		List<String> logList = Files.readAllLines(logPath);
		List<String> ansList = Files.readAllLines(ansPath);
		
		boolean correct = true;
		if (logList.size() == ansList.size()) {
			for (int i = 0; i < ansList.size(); i++) {
				if (!logList.get(i).equals(ansList.get(i))) {
					correct = false;
//					System.out.println("Error at : " + (i + 1));
					System.out.println("--ERROR--");
					System.out.println("[Y] " + (i + 1) + " : " + logList.get(i));
					System.out.println("[A] " + (i + 1) + " : " + ansList.get(i));
				}
			}
		} else {
			System.out.println("解答の行数が異なる");
		}
		if (correct) {
			System.out.println("--OK--");
		} else {
			System.out.println("--NO--");
		}
	}
}
