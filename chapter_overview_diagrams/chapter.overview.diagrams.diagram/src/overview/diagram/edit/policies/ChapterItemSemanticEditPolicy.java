/*
 * 
 */
package overview.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import overview.diagram.edit.commands.InputChapteriCreateCommand;
import overview.diagram.edit.commands.InputChapteriReorientCommand;
import overview.diagram.edit.commands.OutputChapteroCreateCommand;
import overview.diagram.edit.commands.OutputChapteroReorientCommand;
import overview.diagram.edit.parts.InputChapteriEditPart;
import overview.diagram.edit.parts.OutputChapteroEditPart;
import overview.diagram.part.OverviewVisualIDRegistry;
import overview.diagram.providers.OverviewElementTypes;

/**
 * @generated
 */
public class ChapterItemSemanticEditPolicy extends
		OverviewBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChapterItemSemanticEditPolicy() {
		super(OverviewElementTypes.Chapter_2001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (OverviewVisualIDRegistry.getVisualID(incomingLink) == InputChapteriEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (OverviewVisualIDRegistry.getVisualID(incomingLink) == OutputChapteroEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (OverviewElementTypes.InputChapteri_4001 == req.getElementType()) {
			return null;
		}
		if (OverviewElementTypes.OutputChaptero_4002 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (OverviewElementTypes.InputChapteri_4001 == req.getElementType()) {
			return getGEFWrapper(new InputChapteriCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (OverviewElementTypes.OutputChaptero_4002 == req.getElementType()) {
			return getGEFWrapper(new OutputChapteroCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case InputChapteriEditPart.VISUAL_ID:
			return getGEFWrapper(new InputChapteriReorientCommand(req));
		case OutputChapteroEditPart.VISUAL_ID:
			return getGEFWrapper(new OutputChapteroReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
