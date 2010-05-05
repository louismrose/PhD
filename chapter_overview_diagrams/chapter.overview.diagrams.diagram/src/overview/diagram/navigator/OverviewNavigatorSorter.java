/*
 * 
 */
package overview.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import overview.diagram.part.OverviewVisualIDRegistry;

/**
 * @generated
 */
public class OverviewNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 4003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof OverviewNavigatorItem) {
			OverviewNavigatorItem item = (OverviewNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return OverviewVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
