<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="EnumToClasses"/>
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
		<constant value="A.__matchWorlds():V"/>
		<constant value="A.__matchCharacterParameters():V"/>
		<constant value="A.__matchPrincipleParameters():V"/>
		<constant value="A.__matchLocationParameters():V"/>
		<constant value="__exec__"/>
		<constant value="Worlds"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyWorlds(NTransientLink;):V"/>
		<constant value="CharacterParameters"/>
		<constant value="A.__applyCharacterParameters(NTransientLink;):V"/>
		<constant value="PrincipleParameters"/>
		<constant value="A.__applyPrincipleParameters(NTransientLink;):V"/>
		<constant value="LocationParameters"/>
		<constant value="A.__applyLocationParameters(NTransientLink;):V"/>
		<constant value="__matchWorlds"/>
		<constant value="World"/>
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
		<constant value="9:7-9:18"/>
		<constant value="9:3-11:4"/>
		<constant value="__applyWorlds"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="parameters"/>
		<constant value="10:18-10:19"/>
		<constant value="10:18-10:30"/>
		<constant value="10:4-10:30"/>
		<constant value="link"/>
		<constant value="__matchCharacterParameters"/>
		<constant value="Parameter"/>
		<constant value="type"/>
		<constant value="EnumLiteral"/>
		<constant value="character"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="38"/>
		<constant value="CharacterParameter"/>
		<constant value="17:4-17:5"/>
		<constant value="17:4-17:10"/>
		<constant value="17:13-17:23"/>
		<constant value="17:4-17:23"/>
		<constant value="20:7-20:31"/>
		<constant value="20:3-22:4"/>
		<constant value="__applyCharacterParameters"/>
		<constant value="21:12-21:13"/>
		<constant value="21:12-21:18"/>
		<constant value="21:4-21:18"/>
		<constant value="__matchPrincipleParameters"/>
		<constant value="principle"/>
		<constant value="PrincipleParameter"/>
		<constant value="28:4-28:5"/>
		<constant value="28:4-28:10"/>
		<constant value="28:13-28:23"/>
		<constant value="28:4-28:23"/>
		<constant value="31:7-31:31"/>
		<constant value="31:3-33:4"/>
		<constant value="__applyPrincipleParameters"/>
		<constant value="32:12-32:13"/>
		<constant value="32:12-32:18"/>
		<constant value="32:4-32:18"/>
		<constant value="__matchLocationParameters"/>
		<constant value="location"/>
		<constant value="LocationParameter"/>
		<constant value="39:4-39:5"/>
		<constant value="39:4-39:10"/>
		<constant value="39:13-39:22"/>
		<constant value="39:4-39:22"/>
		<constant value="42:7-42:30"/>
		<constant value="42:3-44:4"/>
		<constant value="__applyLocationParameters"/>
		<constant value="43:12-43:13"/>
		<constant value="43:12-43:18"/>
		<constant value="43:4-43:18"/>
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
			<getasm/>
			<call arg="43"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="7"/>
		</localvariabletable>
	</operation>
	<operation name="44">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="45"/>
			<call arg="46"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="47"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="48"/>
			<call arg="46"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="49"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<call arg="46"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="51"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="52"/>
			<call arg="46"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="53"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="1" name="33" begin="35" end="38"/>
			<lve slot="0" name="17" begin="0" end="39"/>
		</localvariabletable>
	</operation>
	<operation name="54">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="55"/>
			<push arg="56"/>
			<findme/>
			<push arg="57"/>
			<call arg="58"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="59"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="45"/>
			<call arg="60"/>
			<dup/>
			<push arg="61"/>
			<load arg="19"/>
			<call arg="62"/>
			<dup/>
			<push arg="63"/>
			<push arg="55"/>
			<push arg="64"/>
			<new/>
			<call arg="65"/>
			<pusht/>
			<call arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="67" begin="21" end="23"/>
			<lne id="68" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="61" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="69">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="74"/>
			<call arg="30"/>
			<set arg="74"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="75" begin="11" end="11"/>
			<lne id="76" begin="11" end="12"/>
			<lne id="77" begin="9" end="14"/>
			<lne id="68" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="63" begin="7" end="15"/>
			<lve slot="2" name="61" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="78" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="79">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="80"/>
			<push arg="56"/>
			<findme/>
			<push arg="57"/>
			<call arg="58"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="81"/>
			<push arg="82"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="83"/>
			<set arg="38"/>
			<call arg="84"/>
			<call arg="85"/>
			<if arg="86"/>
			<getasm/>
			<get arg="1"/>
			<push arg="59"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="48"/>
			<call arg="60"/>
			<dup/>
			<push arg="61"/>
			<load arg="19"/>
			<call arg="62"/>
			<dup/>
			<push arg="63"/>
			<push arg="87"/>
			<push arg="64"/>
			<new/>
			<call arg="65"/>
			<pusht/>
			<call arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="88" begin="7" end="7"/>
			<lne id="89" begin="7" end="8"/>
			<lne id="90" begin="9" end="14"/>
			<lne id="91" begin="7" end="15"/>
			<lne id="92" begin="32" end="34"/>
			<lne id="93" begin="30" end="35"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="61" begin="6" end="37"/>
			<lve slot="0" name="17" begin="0" end="38"/>
		</localvariabletable>
	</operation>
	<operation name="94">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="95" begin="11" end="11"/>
			<lne id="96" begin="11" end="12"/>
			<lne id="97" begin="9" end="14"/>
			<lne id="93" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="63" begin="7" end="15"/>
			<lve slot="2" name="61" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="78" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="98">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="80"/>
			<push arg="56"/>
			<findme/>
			<push arg="57"/>
			<call arg="58"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="81"/>
			<push arg="82"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="99"/>
			<set arg="38"/>
			<call arg="84"/>
			<call arg="85"/>
			<if arg="86"/>
			<getasm/>
			<get arg="1"/>
			<push arg="59"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="50"/>
			<call arg="60"/>
			<dup/>
			<push arg="61"/>
			<load arg="19"/>
			<call arg="62"/>
			<dup/>
			<push arg="63"/>
			<push arg="100"/>
			<push arg="64"/>
			<new/>
			<call arg="65"/>
			<pusht/>
			<call arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="101" begin="7" end="7"/>
			<lne id="102" begin="7" end="8"/>
			<lne id="103" begin="9" end="14"/>
			<lne id="104" begin="7" end="15"/>
			<lne id="105" begin="32" end="34"/>
			<lne id="106" begin="30" end="35"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="61" begin="6" end="37"/>
			<lve slot="0" name="17" begin="0" end="38"/>
		</localvariabletable>
	</operation>
	<operation name="107">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="108" begin="11" end="11"/>
			<lne id="109" begin="11" end="12"/>
			<lne id="110" begin="9" end="14"/>
			<lne id="106" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="63" begin="7" end="15"/>
			<lve slot="2" name="61" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="78" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="111">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="80"/>
			<push arg="56"/>
			<findme/>
			<push arg="57"/>
			<call arg="58"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="81"/>
			<push arg="82"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="112"/>
			<set arg="38"/>
			<call arg="84"/>
			<call arg="85"/>
			<if arg="86"/>
			<getasm/>
			<get arg="1"/>
			<push arg="59"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="52"/>
			<call arg="60"/>
			<dup/>
			<push arg="61"/>
			<load arg="19"/>
			<call arg="62"/>
			<dup/>
			<push arg="63"/>
			<push arg="113"/>
			<push arg="64"/>
			<new/>
			<call arg="65"/>
			<pusht/>
			<call arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="114" begin="7" end="7"/>
			<lne id="115" begin="7" end="8"/>
			<lne id="116" begin="9" end="14"/>
			<lne id="117" begin="7" end="15"/>
			<lne id="118" begin="32" end="34"/>
			<lne id="119" begin="30" end="35"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="61" begin="6" end="37"/>
			<lve slot="0" name="17" begin="0" end="38"/>
		</localvariabletable>
	</operation>
	<operation name="120">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="121" begin="11" end="11"/>
			<lne id="122" begin="11" end="12"/>
			<lne id="123" begin="9" end="14"/>
			<lne id="119" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="63" begin="7" end="15"/>
			<lve slot="2" name="61" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="78" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
