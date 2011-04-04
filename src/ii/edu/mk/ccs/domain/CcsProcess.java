package ii.edu.mk.ccs.domain;

import java.util.ArrayList;
import java.util.Iterator;

import ii.edu.mk.ccs.domain.base.CcsOperation;
import ii.edu.mk.ccs.domain.base.OperatorType;

public class CcsProcess extends CcsOperation {

	private final String name;

	public CcsProcess(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OperatorType getType() {
		return OperatorType.PROCESS;
	}

	@Override
	public Iterator<CcsOperation> iterator() {
		return new ArrayList<CcsOperation>().iterator();
	}

	@Override
	public String toString() {
		return name;
	}
}
