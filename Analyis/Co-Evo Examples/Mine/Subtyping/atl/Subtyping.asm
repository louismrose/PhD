<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="Subtyping"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchDiagramElements():V"/>
		<constant value="__exec__"/>
		<constant value="DiagramElements"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyDiagramElements(NTransientLink;):V"/>
		<constant value="Nodes"/>
		<constant value="A.__applyNodes(NTransientLink;):V"/>
		<constant value="Connections"/>
		<constant value="A.__applyConnections(NTransientLink;):V"/>
		<constant value="Compartments"/>
		<constant value="A.__applyCompartments(NTransientLink;):V"/>
		<constant value="DiagramLabels"/>
		<constant value="A.__applyDiagramLabels(NTransientLink;):V"/>
		<constant value="__matchDiagramElements"/>
		<constant value="DiagramElement"/>
		<constant value="Before"/>
		<constant value="Original"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="Node"/>
		<constant value="B.not():B"/>
		<constant value="71"/>
		<constant value="DiagramLabel"/>
		<constant value="42"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="m"/>
		<constant value="After"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="70"/>
		<constant value="127"/>
		<constant value="Connection"/>
		<constant value="99"/>
		<constant value="Compartment"/>
		<constant value="39:7-39:25"/>
		<constant value="39:3-41:3"/>
		<constant value="18:7-18:17"/>
		<constant value="18:3-18:17"/>
		<constant value="25:7-25:23"/>
		<constant value="25:3-25:23"/>
		<constant value="32:7-32:24"/>
		<constant value="32:3-32:24"/>
		<constant value="__applyNodes"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="figure"/>
		<constant value="J.length():J"/>
		<constant value="10:13-10:14"/>
		<constant value="10:13-10:21"/>
		<constant value="10:13-10:30"/>
		<constant value="10:3-10:30"/>
		<constant value="link"/>
		<constant value="__applyConnections"/>
		<constant value="__applyCompartments"/>
		<constant value="__applyDiagramLabels"/>
		<constant value="accessor"/>
		<constant value="40:15-40:16"/>
		<constant value="40:15-40:25"/>
		<constant value="40:15-40:34"/>
		<constant value="40:3-40:34"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<call arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<call arg="10"/>
			<call arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<call arg="15"/>
			<getasm/>
			<call arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="44"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="45"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="50"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="51"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="52"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="1" name="33" begin="35" end="38"/>
			<lve slot="1" name="33" begin="45" end="48"/>
			<lve slot="0" name="17" begin="0" end="49"/>
		</localvariabletable>
	</operation>
	<operation name="53">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="54"/>
			<push arg="55"/>
			<findme/>
			<push arg="56"/>
			<call arg="57"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<push arg="58"/>
			<push arg="55"/>
			<findme/>
			<call arg="20"/>
			<call arg="59"/>
			<if arg="60"/>
			<load arg="19"/>
			<push arg="61"/>
			<push arg="55"/>
			<findme/>
			<call arg="20"/>
			<call arg="59"/>
			<if arg="62"/>
			<getasm/>
			<get arg="1"/>
			<push arg="63"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="51"/>
			<call arg="64"/>
			<dup/>
			<push arg="65"/>
			<load arg="19"/>
			<call arg="66"/>
			<dup/>
			<push arg="67"/>
			<push arg="61"/>
			<push arg="68"/>
			<new/>
			<call arg="69"/>
			<pusht/>
			<call arg="70"/>
			<goto arg="71"/>
			<load arg="19"/>
			<push arg="58"/>
			<push arg="55"/>
			<findme/>
			<call arg="20"/>
			<call arg="59"/>
			<if arg="71"/>
			<getasm/>
			<get arg="1"/>
			<push arg="63"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="45"/>
			<call arg="64"/>
			<dup/>
			<push arg="65"/>
			<load arg="19"/>
			<call arg="66"/>
			<dup/>
			<push arg="67"/>
			<push arg="58"/>
			<push arg="68"/>
			<new/>
			<call arg="69"/>
			<pusht/>
			<call arg="70"/>
			<goto arg="71"/>
			<goto arg="72"/>
			<load arg="19"/>
			<push arg="73"/>
			<push arg="55"/>
			<findme/>
			<call arg="20"/>
			<call arg="59"/>
			<if arg="74"/>
			<getasm/>
			<get arg="1"/>
			<push arg="63"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<call arg="64"/>
			<dup/>
			<push arg="65"/>
			<load arg="19"/>
			<call arg="66"/>
			<dup/>
			<push arg="67"/>
			<push arg="73"/>
			<push arg="68"/>
			<new/>
			<call arg="69"/>
			<pusht/>
			<call arg="70"/>
			<goto arg="72"/>
			<load arg="19"/>
			<push arg="75"/>
			<push arg="55"/>
			<findme/>
			<call arg="20"/>
			<call arg="59"/>
			<if arg="72"/>
			<getasm/>
			<get arg="1"/>
			<push arg="63"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<call arg="64"/>
			<dup/>
			<push arg="65"/>
			<load arg="19"/>
			<call arg="66"/>
			<dup/>
			<push arg="67"/>
			<push arg="75"/>
			<push arg="68"/>
			<new/>
			<call arg="69"/>
			<pusht/>
			<call arg="70"/>
			<goto arg="72"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="76" begin="35" end="37"/>
			<lne id="77" begin="33" end="38"/>
			<lne id="78" begin="63" end="65"/>
			<lne id="79" begin="61" end="66"/>
			<lne id="80" begin="92" end="94"/>
			<lne id="81" begin="90" end="95"/>
			<lne id="82" begin="120" end="122"/>
			<lne id="83" begin="118" end="123"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="65" begin="6" end="126"/>
			<lve slot="0" name="17" begin="0" end="127"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="86"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="87"/>
			<store arg="88"/>
			<load arg="88"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="89"/>
			<call arg="90"/>
			<call arg="30"/>
			<set arg="89"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="11" end="12"/>
			<lne id="93" begin="11" end="13"/>
			<lne id="94" begin="9" end="15"/>
			<lne id="79" begin="8" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="67" begin="7" end="16"/>
			<lve slot="2" name="65" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="95" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="96">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="86"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="87"/>
			<store arg="88"/>
			<load arg="88"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="89"/>
			<call arg="90"/>
			<call arg="30"/>
			<set arg="89"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="11" end="12"/>
			<lne id="93" begin="11" end="13"/>
			<lne id="94" begin="9" end="15"/>
			<lne id="81" begin="8" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="67" begin="7" end="16"/>
			<lve slot="2" name="65" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="95" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="97">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="86"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="87"/>
			<store arg="88"/>
			<load arg="88"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="89"/>
			<call arg="90"/>
			<call arg="30"/>
			<set arg="89"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="11" end="12"/>
			<lne id="93" begin="11" end="13"/>
			<lne id="94" begin="9" end="15"/>
			<lne id="83" begin="8" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="67" begin="7" end="16"/>
			<lve slot="2" name="65" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="95" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="98">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="86"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="87"/>
			<store arg="88"/>
			<load arg="88"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="99"/>
			<call arg="90"/>
			<call arg="30"/>
			<set arg="99"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="89"/>
			<call arg="90"/>
			<call arg="30"/>
			<set arg="89"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="100" begin="11" end="11"/>
			<lne id="101" begin="11" end="12"/>
			<lne id="102" begin="11" end="13"/>
			<lne id="103" begin="9" end="15"/>
			<lne id="91" begin="18" end="18"/>
			<lne id="92" begin="18" end="19"/>
			<lne id="93" begin="18" end="20"/>
			<lne id="94" begin="16" end="22"/>
			<lne id="77" begin="8" end="23"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="67" begin="7" end="23"/>
			<lve slot="2" name="65" begin="3" end="23"/>
			<lve slot="0" name="17" begin="0" end="23"/>
			<lve slot="1" name="95" begin="0" end="23"/>
		</localvariabletable>
	</operation>
</asm>
