/*
 * 
 */
package overview.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import overview.diagram.providers.OverviewElementTypes;

/**
 * @generated
 */
public class OutputChapteroItemSemanticEditPolicy extends
		OverviewBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public OutputChapteroItemSemanticEditPolicy() {
		super(OverviewElementTypes.OutputChaptero_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
