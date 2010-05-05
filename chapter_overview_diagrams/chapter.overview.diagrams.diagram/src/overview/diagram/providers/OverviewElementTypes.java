/*
 * 
 */
package overview.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import overview.OverviewPackage;
import overview.diagram.edit.parts.ChapterEditPart;
import overview.diagram.edit.parts.InputChapteriEditPart;
import overview.diagram.edit.parts.InputEditPart;
import overview.diagram.edit.parts.OutputChapteroEditPart;
import overview.diagram.edit.parts.OutputEditPart;
import overview.diagram.edit.parts.OverviewEditPart;
import overview.diagram.part.OverviewDiagramEditorPlugin;

/**
 * @generated
 */
public class OverviewElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private OverviewElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Overview_1000 = getElementType("chapter.overview.diagrams.diagram.Overview_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Chapter_2001 = getElementType("chapter.overview.diagrams.diagram.Chapter_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Input_2002 = getElementType("chapter.overview.diagrams.diagram.Input_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Output_2003 = getElementType("chapter.overview.diagrams.diagram.Output_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputChapteri_4001 = getElementType("chapter.overview.diagrams.diagram.InputChapteri_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OutputChaptero_4002 = getElementType("chapter.overview.diagrams.diagram.OutputChaptero_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return OverviewDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements
					.put(Overview_1000, OverviewPackage.eINSTANCE.getOverview());

			elements.put(Chapter_2001, OverviewPackage.eINSTANCE.getChapter());

			elements.put(Input_2002, OverviewPackage.eINSTANCE.getInput());

			elements.put(Output_2003, OverviewPackage.eINSTANCE.getOutput());

			elements.put(InputChapteri_4001, OverviewPackage.eINSTANCE
					.getInput_Chapteri());

			elements.put(OutputChaptero_4002, OverviewPackage.eINSTANCE
					.getOutput_Chaptero());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Overview_1000);
			KNOWN_ELEMENT_TYPES.add(Chapter_2001);
			KNOWN_ELEMENT_TYPES.add(Input_2002);
			KNOWN_ELEMENT_TYPES.add(Output_2003);
			KNOWN_ELEMENT_TYPES.add(InputChapteri_4001);
			KNOWN_ELEMENT_TYPES.add(OutputChaptero_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case OverviewEditPart.VISUAL_ID:
			return Overview_1000;
		case ChapterEditPart.VISUAL_ID:
			return Chapter_2001;
		case InputEditPart.VISUAL_ID:
			return Input_2002;
		case OutputEditPart.VISUAL_ID:
			return Output_2003;
		case InputChapteriEditPart.VISUAL_ID:
			return InputChapteri_4001;
		case OutputChapteroEditPart.VISUAL_ID:
			return OutputChaptero_4002;
		}
		return null;
	}

}
