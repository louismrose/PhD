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
public class InputChapteriItemSemanticEditPolicy extends
		OverviewBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InputChapteriItemSemanticEditPolicy() {
		super(OverviewElementTypes.InputChapteri_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
