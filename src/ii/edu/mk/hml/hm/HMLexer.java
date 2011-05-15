package ii.edu.mk.hml.hm;

import ii.edu.mk.hml.utils.Graph;
import ii.edu.mk.hml.utils.Node;
import ii.edu.mk.hml.exceptions.NodeIsNull;
import ii.edu.mk.hml.exceptions.NodeNotInTheGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HMLexer
{

	private HMParser parser;
	private Graph graph;
	
	/**
	 * All tokens. (Lambda means empty)
	 */
	public static final String[] tokens =
	{ "AND", "OR", "UW", "US", "NOT", "[", "]", "<", ">", "TT", "FF", "(", ")", "{", "}", "," };

	
	public HMLexer(File file)
	{
		graph = generateGreph(file);

		try
		{
			graph.setStartNode(graph.getNode(0));
		}
		catch (NodeIsNull e)
		{
			e.printStackTrace();
		}
		catch (NodeNotInTheGraph e)
		{
			e.printStackTrace();
		}
	}

	public Graph generateGreph(File file)
	{
		Graph graph = new Graph();
		try
		{
			Scanner scanner = new Scanner(file);

			String descriptor = scanner.nextLine();
			String des = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));

			String[] desElements = des.split(", ");
			String start = desElements[0];
			int numberTransitions = Integer.parseInt(desElements[1]);
			int numberStates = Integer.parseInt(desElements[2]);

			Node nodes[] = new Node[numberStates];
			nodes[0] = new Node(start);

			graph.addNode(nodes[0]);

			for (int i = 1; i <= numberTransitions; i++)
			{
				String edge = scanner.nextLine();
				String ed = edge.substring(edge.indexOf('(') + 1, edge.indexOf(')'));

				String[] edgeElements = ed.split(", ");

				Node node1 = new Node(edgeElements[0]);
				Node node2 = new Node(edgeElements[2]);
				String action = edgeElements[1];

				graph.connectNodes(node1, node2, action);

			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (NodeIsNull e)
		{
			e.printStackTrace();
		}

		return graph;
	}

	/**
	 * Tokenization is the process of demarcating and possibly classifying sections of a string of
	 * input characters. The resulting tokens are then passed on to some other form of processing.
	 * The process can be considered a sub-task of parsing input.
	 * 
	 * @param expression String that should be parsed
	 * @return String witch may be: error or result of expression evaluation.
	 */
	public String tokenization(String expression)
	{
	  //New parser for each expression
	  try {
      parser = new HMParser(graph.getStartNode());
    } catch (NodeIsNull e) {
      e.printStackTrace();
    }
    String oldExpression = expression;
	  
		expression = formatText(expression);
		String tmpToken = "";
		for (char c : expression.toCharArray())
		{
			tmpToken += c + "";

			if (isToken(tmpToken))
			{
				/*
				 * Tries to parse the token. If the result is string with length > 0, then an error
				 * has occurred and the tokenization stops.
				 */
				String result = parser.parse(tmpToken);
				if (result.length() > 0)
				{
				  return oldExpression + " => " + result;
				}

				tmpToken = "";
			}
		}


		// final conditions before showing the result
		if (tmpToken.length() == 0 && parser.isEverythingOK())
		{
			return oldExpression + " => " + parser.getFinalResult();
		}
		return oldExpression + " => " + "ERROR: The expression is not valid.";
	}

	/**
	 * Is string token.
	 * 
	 * @param token
	 * @return true if string is already defined token
	 */
	public boolean isToken(String token)
	{
		for (String s : tokens)
			if (s.compareTo(token) == 0)
				return true;

		if (token.length() == 1 && Character.isLetter(token.charAt(0))
				&& Character.isLowerCase(token.charAt(0)))
			return true;

		if (token.length() == 1 && Character.isDigit(token.charAt(0)))
			return true;

		return false;
	}

	/**
	 * Format text: all actions are with lower case, Key word are with upper case, Remove blank
	 * spaces
	 * 
	 * @param text
	 * @return String
	 */
	public String formatText(String text)
	{
		String newText = text.toLowerCase();
		newText = newText.replace(" ", "");

		for (int i = 0; i < 5; i++)
			newText = newText.replace(tokens[i].toLowerCase(), tokens[i].toUpperCase());

		newText = newText.replace(tokens[9].toLowerCase(), tokens[9].toUpperCase());
		newText = newText.replace(tokens[10].toLowerCase(), tokens[10].toUpperCase());

		return newText;
	}
}
