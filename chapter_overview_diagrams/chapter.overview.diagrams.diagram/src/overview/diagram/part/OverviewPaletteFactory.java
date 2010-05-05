/*
 * 
 */
package overview.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import overview.diagram.providers.OverviewElementTypes;

/**
 * @generated
 */
public class OverviewPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createChapter1CreationTool());
		paletteContainer.add(createInput2CreationTool());
		paletteContainer.add(createOutput3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createChapteri1CreationTool());
		paletteContainer.add(createChaptero2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChapter1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OverviewElementTypes.Chapter_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Chapter1CreationTool_title,
				Messages.Chapter1CreationTool_desc, types);
		entry.setId("createChapter1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OverviewElementTypes
				.getImageDescriptor(OverviewElementTypes.Chapter_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInput2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OverviewElementTypes.Input_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Input2CreationTool_title,
				Messages.Input2CreationTool_desc, types);
		entry.setId("createInput2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OverviewElementTypes
				.getImageDescriptor(OverviewElementTypes.Input_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutput3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OverviewElementTypes.Output_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Output3CreationTool_title,
				Messages.Output3CreationTool_desc, types);
		entry.setId("createOutput3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OverviewElementTypes
				.getImageDescriptor(OverviewElementTypes.Output_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChapteri1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OverviewElementTypes.InputChapteri_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Chapteri1CreationTool_title,
				Messages.Chapteri1CreationTool_desc, types);
		entry.setId("createChapteri1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OverviewElementTypes
				.getImageDescriptor(OverviewElementTypes.InputChapteri_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChaptero2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OverviewElementTypes.OutputChaptero_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Chaptero2CreationTool_title,
				Messages.Chaptero2CreationTool_desc, types);
		entry.setId("createChaptero2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OverviewElementTypes
				.getImageDescriptor(OverviewElementTypes.OutputChaptero_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
