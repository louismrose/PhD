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
		<constant value="A.__matchPersons():V"/>
		<constant value="__exec__"/>
		<constant value="Systems"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applySystems(NTransientLink;):V"/>
		<constant value="Persons"/>
		<constant value="A.__applyPersons(NTransientLink;):V"/>
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
		<constant value="people"/>
		<constant value="10:14-10:15"/>
		<constant value="10:14-10:22"/>
		<constant value="10:4-10:22"/>
		<constant value="link"/>
		<constant value="__matchPersons"/>
		<constant value="Person"/>
		<constant value="t"/>
		<constant value="TelephoneNumber"/>
		<constant value="18:7-18:19"/>
		<constant value="18:3-21:4"/>
		<constant value="22:7-22:28"/>
		<constant value="22:3-25:4"/>
		<constant value="__applyPersons"/>
		<constant value="4"/>
		<constant value="telephoneNumber"/>
		<constant value="areaCode"/>
		<constant value="number"/>
		<constant value="19:12-19:13"/>
		<constant value="19:12-19:18"/>
		<constant value="19:4-19:18"/>
		<constant value="20:23-20:24"/>
		<constant value="20:4-20:24"/>
		<constant value="23:16-23:17"/>
		<constant value="23:16-23:26"/>
		<constant value="23:4-23:26"/>
		<constant value="24:14-24:15"/>
		<constant value="24:14-24:22"/>
		<constant value="24:4-24:22"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<call arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="19"/>
			<call arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="49"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<pusht/>
			<call arg="60"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="61" begin="21" end="23"/>
			<lne id="62" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="55" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="63">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="64"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="65"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="66"/>
			<store arg="67"/>
			<load arg="67"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="68"/>
			<call arg="30"/>
			<set arg="68"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="69" begin="11" end="11"/>
			<lne id="70" begin="11" end="12"/>
			<lne id="71" begin="9" end="14"/>
			<lne id="62" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="57" begin="7" end="15"/>
			<lve slot="2" name="55" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="72" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="73">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="74"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<call arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="19"/>
			<call arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="74"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<dup/>
			<push arg="75"/>
			<push arg="76"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<pusht/>
			<call arg="60"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="77" begin="21" end="23"/>
			<lne id="78" begin="19" end="24"/>
			<lne id="79" begin="27" end="29"/>
			<lne id="80" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="55" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="81">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="64"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="65"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="66"/>
			<store arg="67"/>
			<load arg="19"/>
			<push arg="75"/>
			<call arg="66"/>
			<store arg="82"/>
			<load arg="67"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="82"/>
			<call arg="30"/>
			<set arg="83"/>
			<pop/>
			<load arg="82"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="84"/>
			<call arg="30"/>
			<set arg="84"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="85"/>
			<call arg="30"/>
			<set arg="85"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="86" begin="15" end="15"/>
			<lne id="87" begin="15" end="16"/>
			<lne id="88" begin="13" end="18"/>
			<lne id="89" begin="21" end="21"/>
			<lne id="90" begin="19" end="23"/>
			<lne id="78" begin="12" end="24"/>
			<lne id="91" begin="28" end="28"/>
			<lne id="92" begin="28" end="29"/>
			<lne id="93" begin="26" end="31"/>
			<lne id="94" begin="34" end="34"/>
			<lne id="95" begin="34" end="35"/>
			<lne id="96" begin="32" end="37"/>
			<lne id="80" begin="25" end="38"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="57" begin="7" end="38"/>
			<lve slot="4" name="75" begin="11" end="38"/>
			<lve slot="2" name="55" begin="3" end="38"/>
			<lve slot="0" name="17" begin="0" end="38"/>
			<lve slot="1" name="72" begin="0" end="38"/>
		</localvariabletable>
	</operation>
</asm>
