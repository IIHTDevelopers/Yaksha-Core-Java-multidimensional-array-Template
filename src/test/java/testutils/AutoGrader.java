package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

public class AutoGrader {

	// Test if the code uses proper multi-dimensional array manipulation techniques
	// and correct logic
	public boolean testMultiArrayOperations(String filePath) throws IOException {
		System.out.println("Starting testMultiArrayOperations with file: " + filePath);

		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		boolean hasMultiArrayOperations = false;

		// Check for multi-dimensional array declarations
		System.out.println("------ Multi-Dimensional Array Declarations ------");
		for (VariableDeclarator var : cu.findAll(VariableDeclarator.class)) {
			if (var.getType().asString().contains("int[][]")) {
				System.out.println("Multi-dimensional array declaration found: " + var);
				hasMultiArrayOperations = true;
			}
		}

		// Check for multi-dimensional array creation
		System.out.println("------ Multi-Dimensional Array Creation ------");
		for (ArrayCreationExpr arrayCreation : cu.findAll(ArrayCreationExpr.class)) {
			if (arrayCreation.getElementType().asString().equals("int") && arrayCreation.getLevels().size() == 2) {
				System.out.println("Multi-dimensional array creation found: " + arrayCreation);
				hasMultiArrayOperations = true;
			}
		}

		// Check for traditional array iteration using for loops
		System.out.println("------ Array Iteration ------");
		for (ForStmt forStmt : cu.findAll(ForStmt.class)) {
			if (forStmt.getBody().toString().contains("int[][]")) {
				System.out.println("Array iteration found using for loop: " + forStmt);
				hasMultiArrayOperations = true;
			}
		}

		// Check for while and do-while loops (for completeness)
		for (WhileStmt whileStmt : cu.findAll(WhileStmt.class)) {
			if (whileStmt.getCondition().toString().contains("length")) {
				System.out.println("Array iteration found using while loop: " + whileStmt);
				hasMultiArrayOperations = true;
			}
		}

		for (DoStmt doStmt : cu.findAll(DoStmt.class)) {
			if (doStmt.getCondition().toString().contains("length")) {
				System.out.println("Array iteration found using do-while loop: " + doStmt);
				hasMultiArrayOperations = true;
			}
		}

		// Return whether multi-dimensional array-related operations are found
		System.out.println("Has correct multi-dimensional array operations: " + hasMultiArrayOperations);

		boolean result = hasMultiArrayOperations;
		System.out.println("Test result: " + result);

		return result;
	}
}
