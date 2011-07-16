<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="ExtractClass"/>
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
		<constant value="A.__matchSystems():V"/>
		<constant value="A.__matchJobItems():V"/>
		<constant value="A.__matchLabourItems():V"/>
		<constant value="__exec__"/>
		<constant value="Systems"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applySystems(NTransientLink;):V"/>
		<constant value="JobItems"/>
		<constant value="A.__applyJobItems(NTransientLink;):V"/>
		<constant value="LabourItems"/>
		<constant value="A.__applyLabourItems(NTransientLink;):V"/>
		<constant value="__matchSystems"/>
		<constant value="System"/>
		<constant value="Before"/>
		<constant value="Original"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="m"/>
		<constant value="After"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="9:7-9:19"/>
		<constant value="9:3-11:4"/>
		<constant value="__applySystems"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="items"/>
		<constant value="10:13-10:14"/>
		<constant value="10:13-10:20"/>
		<constant value="10:4-10:20"/>
		<constant value="link"/>
		<constant value="__matchJobItems"/>
		<constant value="JobItem"/>
		<constant value="employee"/>
		<constant value="J.size():J"/>
		<constant value="0"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="34"/>
		<constant value="17:4-17:5"/>
		<constant value="17:4-17:14"/>
		<constant value="17:4-17:21"/>
		<constant value="17:24-17:25"/>
		<constant value="17:4-17:25"/>
		<constant value="20:7-20:20"/>
		<constant value="20:3-23:4"/>
		<constant value="__applyJobItems"/>
		<constant value="jobPrice"/>
		<constant value="totalPrice"/>
		<constant value="21:16-21:17"/>
		<constant value="21:16-21:26"/>
		<constant value="21:4-21:26"/>
		<constant value="22:18-22:19"/>
		<constant value="22:18-22:30"/>
		<constant value="22:4-22:30"/>
		<constant value="__matchLabourItems"/>
		<constant value="J.&gt;(J):J"/>
		<constant value="LabourItem"/>
		<constant value="29:4-29:5"/>
		<constant value="29:4-29:14"/>
		<constant value="29:4-29:21"/>
		<constant value="29:24-29:25"/>
		<constant value="29:4-29:25"/>
		<constant value="32:7-32:23"/>
		<constant value="32:3-36:4"/>
		<constant value="__applyLabourItems"/>
		<constant value="33:16-33:17"/>
		<constant value="33:16-33:26"/>
		<constant value="33:4-33:26"/>
		<constant value="34:18-34:19"/>
		<constant value="34:18-34:30"/>
		<constant value="34:4-34:30"/>
		<constant value="35:16-35:17"/>
		<constant value="35:16-35:26"/>
		<constant value="35:4-35:26"/>
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
			<getasm/>
			<call arg="41"/>
			<getasm/>
			<call arg="42"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="5"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="50"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="44"/>
			<call arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="52"/>
			<push arg="61"/>
			<new/>
			<call arg="62"/>
			<pusht/>
			<call arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="64" begin="21" end="23"/>
			<lne id="65" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="66">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="67"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="68"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="69"/>
			<store arg="70"/>
			<load arg="70"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="71"/>
			<call arg="30"/>
			<set arg="71"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="72" begin="11" end="11"/>
			<lne id="73" begin="11" end="12"/>
			<lne id="74" begin="9" end="14"/>
			<lne id="65" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="60" begin="7" end="15"/>
			<lve slot="2" name="58" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="75" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="76">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="77"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="78"/>
			<call arg="79"/>
			<pushi arg="80"/>
			<call arg="81"/>
			<call arg="82"/>
			<if arg="83"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<call arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="77"/>
			<push arg="61"/>
			<new/>
			<call arg="62"/>
			<pusht/>
			<call arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="84" begin="7" end="7"/>
			<lne id="85" begin="7" end="8"/>
			<lne id="86" begin="7" end="9"/>
			<lne id="87" begin="10" end="10"/>
			<lne id="88" begin="7" end="11"/>
			<lne id="89" begin="28" end="30"/>
			<lne id="90" begin="26" end="31"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="33"/>
			<lve slot="0" name="17" begin="0" end="34"/>
		</localvariabletable>
	</operation>
	<operation name="91">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="67"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="68"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="69"/>
			<store arg="70"/>
			<load arg="70"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="92"/>
			<call arg="30"/>
			<set arg="92"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="93"/>
			<call arg="30"/>
			<set arg="93"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="94" begin="11" end="11"/>
			<lne id="95" begin="11" end="12"/>
			<lne id="96" begin="9" end="14"/>
			<lne id="97" begin="17" end="17"/>
			<lne id="98" begin="17" end="18"/>
			<lne id="99" begin="15" end="20"/>
			<lne id="90" begin="8" end="21"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="60" begin="7" end="21"/>
			<lve slot="2" name="58" begin="3" end="21"/>
			<lve slot="0" name="17" begin="0" end="21"/>
			<lve slot="1" name="75" begin="0" end="21"/>
		</localvariabletable>
	</operation>
	<operation name="100">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="77"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="78"/>
			<call arg="79"/>
			<pushi arg="80"/>
			<call arg="101"/>
			<call arg="82"/>
			<if arg="83"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<call arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="102"/>
			<push arg="61"/>
			<new/>
			<call arg="62"/>
			<pusht/>
			<call arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="103" begin="7" end="7"/>
			<lne id="104" begin="7" end="8"/>
			<lne id="105" begin="7" end="9"/>
			<lne id="106" begin="10" end="10"/>
			<lne id="107" begin="7" end="11"/>
			<lne id="108" begin="28" end="30"/>
			<lne id="109" begin="26" end="31"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="33"/>
			<lve slot="0" name="17" begin="0" end="34"/>
		</localvariabletable>
	</operation>
	<operation name="110">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="67"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="68"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="69"/>
			<store arg="70"/>
			<load arg="70"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="92"/>
			<call arg="30"/>
			<set arg="92"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="93"/>
			<call arg="30"/>
			<set arg="93"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="78"/>
			<call arg="30"/>
			<set arg="78"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="111" begin="11" end="11"/>
			<lne id="112" begin="11" end="12"/>
			<lne id="113" begin="9" end="14"/>
			<lne id="114" begin="17" end="17"/>
			<lne id="115" begin="17" end="18"/>
			<lne id="116" begin="15" end="20"/>
			<lne id="117" begin="23" end="23"/>
			<lne id="118" begin="23" end="24"/>
			<lne id="119" begin="21" end="26"/>
			<lne id="109" begin="8" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="60" begin="7" end="27"/>
			<lve slot="2" name="58" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="75" begin="0" end="27"/>
		</localvariabletable>
	</operation>
</asm>
