/*
 * 
 */
package overview.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import overview.Chapter;
import overview.Input;
import overview.Output;
import overview.Overview;
import overview.OverviewPackage;
import overview.diagram.edit.parts.ChapterEditPart;
import overview.diagram.edit.parts.InputChapteriEditPart;
import overview.diagram.edit.parts.InputEditPart;
import overview.diagram.edit.parts.OutputChapteroEditPart;
import overview.diagram.edit.parts.OutputEditPart;
import overview.diagram.edit.parts.OverviewEditPart;
import overview.diagram.providers.OverviewElementTypes;

/**
 * @generated
 */
public class OverviewDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case OverviewEditPart.VISUAL_ID:
			return getOverview_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOverview_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Overview modelElement = (Overview) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getChapterrs().iterator(); it.hasNext();) {
			Chapter childElement = (Chapter) it.next();
			int visualID = OverviewVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ChapterEditPart.VISUAL_ID) {
				result.add(new OverviewNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInputs().iterator(); it.hasNext();) {
			Input childElement = (Input) it.next();
			int visualID = OverviewVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InputEditPart.VISUAL_ID) {
				result.add(new OverviewNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOutputs().iterator(); it.hasNext();) {
			Output childElement = (Output) it.next();
			int visualID = OverviewVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OutputEditPart.VISUAL_ID) {
				result.add(new OverviewNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case OverviewEditPart.VISUAL_ID:
			return getOverview_1000ContainedLinks(view);
		case ChapterEditPart.VISUAL_ID:
			return getChapter_2001ContainedLinks(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002ContainedLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case ChapterEditPart.VISUAL_ID:
			return getChapter_2001IncomingLinks(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002IncomingLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case ChapterEditPart.VISUAL_ID:
			return getChapter_2001OutgoingLinks(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002OutgoingLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOverview_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getChapter_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInput_2002ContainedLinks(View view) {
		Input modelElement = (Input) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Input_Chapteri_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutput_2003ContainedLinks(View view) {
		Output modelElement = (Output) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Output_Chaptero_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getChapter_2001IncomingLinks(View view) {
		Chapter modelElement = (Chapter) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Input_Chapteri_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Output_Chaptero_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInput_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutput_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getChapter_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInput_2002OutgoingLinks(View view) {
		Input modelElement = (Input) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Input_Chapteri_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutput_2003OutgoingLinks(View view) {
		Output modelElement = (Output) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Output_Chaptero_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Input_Chapteri_4001(
			Chapter target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == OverviewPackage.eINSTANCE
					.getInput_Chapteri()) {
				result.add(new OverviewLinkDescriptor(setting.getEObject(),
						target, OverviewElementTypes.InputChapteri_4001,
						InputChapteriEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Output_Chaptero_4002(
			Chapter target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == OverviewPackage.eINSTANCE
					.getOutput_Chaptero()) {
				result.add(new OverviewLinkDescriptor(setting.getEObject(),
						target, OverviewElementTypes.OutputChaptero_4002,
						OutputChapteroEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Input_Chapteri_4001(
			Input source) {
		Collection result = new LinkedList();
		Chapter destination = source.getChapteri();
		if (destination == null) {
			return result;
		}
		result.add(new OverviewLinkDescriptor(source, destination,
				OverviewElementTypes.InputChapteri_4001,
				InputChapteriEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Output_Chaptero_4002(
			Output source) {
		Collection result = new LinkedList();
		Chapter destination = source.getChaptero();
		if (destination == null) {
			return result;
		}
		result.add(new OverviewLinkDescriptor(source, destination,
				OverviewElementTypes.OutputChaptero_4002,
				OutputChapteroEditPart.VISUAL_ID));
		return result;
	}

}
