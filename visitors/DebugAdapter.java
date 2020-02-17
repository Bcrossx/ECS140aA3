package nada.visitors;
import java.util.*;
import java.io.*;
import nada.node.*;
import nada.analysis.*;

public class DebugAdapter extends DepthFirstAdapter
{

	public void defaultIn(Node node)
	{
		System.err.println("IN:" + node.getClass().getSimpleName() + ":" + node);

	}

	public void defaultOut(Node node)
	{
		System.err.println("OUT:" + node.getClass().getSimpleName() + ":" + node);
	}

}