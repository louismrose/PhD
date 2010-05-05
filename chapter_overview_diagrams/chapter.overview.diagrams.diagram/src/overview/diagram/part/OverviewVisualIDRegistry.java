/*
 * 
 */
package overview.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import overview.Overview;
import overview.OverviewPackage;
import overview.diagram.edit.parts.ChapterEditPart;
import overview.diagram.edit.parts.ChapterNameEditPart;
import overview.diagram.edit.parts.InputChapteriEditPart;
import overview.diagram.edit.parts.InputEditPart;
import overview.diagram.edit.parts.InputNameEditPart;
import overview.diagram.edit.parts.OutputChapteroEditPart;
import overview.diagram.edit.parts.OutputEditPart;
import overview.diagram.edit.parts.OutputNameEditPart;
import overview.diagram.edit.parts.OverviewEditPart;
import overview.diagram.edit.parts.WrappingLabel2EditPart;
import overview.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class OverviewVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "chapter.overview.diagrams.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (OverviewEditPart.MODEL_ID.equals(view.getType())) {
				return OverviewEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return overview.diagram.part.OverviewVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				OverviewDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (OverviewPackage.eINSTANCE.getOverview().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Overview) domainElement)) {
			return OverviewEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = overview.diagram.part.OverviewVisualIDRegistry
				.getModelID(containerView);
		if (!OverviewEditPart.MODEL_ID.equals(containerModelID)
				&& !"overview".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (OverviewEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = overview.diagram.part.OverviewVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = OverviewEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case OverviewEditPart.VISUAL_ID:
			if (OverviewPackage.eINSTANCE.getChapter().isSuperTypeOf(
					domainElement.eClass())) {
				return ChapterEditPart.VISUAL_ID;
			}
			if (OverviewPackage.eINSTANCE.getInput().isSuperTypeOf(
					domainElement.eClass())) {
				return InputEditPart.VISUAL_ID;
			}
			if (OverviewPackage.eINSTANCE.getOutput().isSuperTypeOf(
					domainElement.eClass())) {
				return OutputEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = overview.diagram.part.OverviewVisualIDRegistry
				.getModelID(containerView);
		if (!OverviewEditPart.MODEL_ID.equals(containerModelID)
				&& !"overview".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (OverviewEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = overview.diagram.part.OverviewVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = OverviewEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ChapterEditPart.VISUAL_ID:
			if (ChapterNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputEditPart.VISUAL_ID:
			if (InputNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputEditPart.VISUAL_ID:
			if (OutputNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OverviewEditPart.VISUAL_ID:
			if (ChapterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputChapteriEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputChapteroEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Overview element) {
		return true;
	}

}
