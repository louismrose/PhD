/*
 * 
 */
package overview.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import overview.diagram.edit.parts.ChapterEditPart;
import overview.diagram.edit.parts.ChapterNameEditPart;
import overview.diagram.edit.parts.InputChapteriEditPart;
import overview.diagram.edit.parts.InputEditPart;
import overview.diagram.edit.parts.InputNameEditPart;
import overview.diagram.edit.parts.OutputChapteroEditPart;
import overview.diagram.edit.parts.OutputEditPart;
import overview.diagram.edit.parts.OutputNameEditPart;
import overview.diagram.edit.parts.OverviewEditPart;
import overview.diagram.part.OverviewDiagramEditorPlugin;
import overview.diagram.part.OverviewVisualIDRegistry;
import overview.diagram.providers.OverviewElementTypes;
import overview.diagram.providers.OverviewParserProvider;

/**
 * @generated
 */
public class OverviewNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		OverviewDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		OverviewDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof OverviewNavigatorItem
				&& !isOwnView(((OverviewNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof OverviewNavigatorGroup) {
			OverviewNavigatorGroup group = (OverviewNavigatorGroup) element;
			return OverviewDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof OverviewNavigatorItem) {
			OverviewNavigatorItem navigatorItem = (OverviewNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case OverviewEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?overview?Overview", OverviewElementTypes.Overview_1000); //$NON-NLS-1$
		case ChapterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?overview?Chapter", OverviewElementTypes.Chapter_2001); //$NON-NLS-1$
		case InputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?overview?Input", OverviewElementTypes.Input_2002); //$NON-NLS-1$
		case OutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?overview?Output", OverviewElementTypes.Output_2003); //$NON-NLS-1$
		case InputChapteriEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?overview?Input?chapteri", OverviewElementTypes.InputChapteri_4001); //$NON-NLS-1$
		case OutputChapteroEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?overview?Output?chaptero", OverviewElementTypes.OutputChaptero_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = OverviewDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& OverviewElementTypes.isKnownElementType(elementType)) {
			image = OverviewElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof OverviewNavigatorGroup) {
			OverviewNavigatorGroup group = (OverviewNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof OverviewNavigatorItem) {
			OverviewNavigatorItem navigatorItem = (OverviewNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (OverviewVisualIDRegistry.getVisualID(view)) {
		case OverviewEditPart.VISUAL_ID:
			return getOverview_1000Text(view);
		case ChapterEditPart.VISUAL_ID:
			return getChapter_2001Text(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002Text(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003Text(view);
		case InputChapteriEditPart.VISUAL_ID:
			return getInputChapteri_4001Text(view);
		case OutputChapteroEditPart.VISUAL_ID:
			return getOutputChaptero_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getOverview_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getChapter_2001Text(View view) {
		IParser parser = OverviewParserProvider
				.getParser(OverviewElementTypes.Chapter_2001,
						view.getElement() != null ? view.getElement() : view,
						OverviewVisualIDRegistry
								.getType(ChapterNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OverviewDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInput_2002Text(View view) {
		IParser parser = OverviewParserProvider.getParser(
				OverviewElementTypes.Input_2002,
				view.getElement() != null ? view.getElement() : view,
				OverviewVisualIDRegistry.getType(InputNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OverviewDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutput_2003Text(View view) {
		IParser parser = OverviewParserProvider.getParser(
				OverviewElementTypes.Output_2003,
				view.getElement() != null ? view.getElement() : view,
				OverviewVisualIDRegistry.getType(OutputNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OverviewDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputChapteri_4001Text(View view) {
		IParser parser = OverviewParserProvider.getParser(
				OverviewElementTypes.InputChapteri_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OverviewDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputChaptero_4002Text(View view) {
		IParser parser = OverviewParserProvider.getParser(
				OverviewElementTypes.OutputChaptero_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OverviewDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return OverviewEditPart.MODEL_ID.equals(OverviewVisualIDRegistry
				.getModelID(view));
	}

}
