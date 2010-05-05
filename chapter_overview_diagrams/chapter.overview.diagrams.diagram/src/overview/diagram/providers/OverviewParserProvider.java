/*
 * 
 */
package overview.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import overview.OverviewPackage;
import overview.diagram.edit.parts.ChapterNameEditPart;
import overview.diagram.edit.parts.InputNameEditPart;
import overview.diagram.edit.parts.OutputNameEditPart;
import overview.diagram.parsers.MessageFormatParser;
import overview.diagram.part.OverviewVisualIDRegistry;

/**
 * @generated
 */
public class OverviewParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser chapterName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getChapterName_5001Parser() {
		if (chapterName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { OverviewPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			chapterName_5001Parser = parser;
		}
		return chapterName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser inputName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getInputName_5002Parser() {
		if (inputName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { OverviewPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inputName_5002Parser = parser;
		}
		return inputName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser outputName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getOutputName_5003Parser() {
		if (outputName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { OverviewPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			outputName_5003Parser = parser;
		}
		return outputName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ChapterNameEditPart.VISUAL_ID:
			return getChapterName_5001Parser();
		case InputNameEditPart.VISUAL_ID:
			return getInputName_5002Parser();
		case OutputNameEditPart.VISUAL_ID:
			return getOutputName_5003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(OverviewVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(OverviewVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (OverviewElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
