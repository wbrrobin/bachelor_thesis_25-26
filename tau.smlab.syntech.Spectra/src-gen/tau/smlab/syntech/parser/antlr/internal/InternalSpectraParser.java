package tau.smlab.syntech.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import tau.smlab.syntech.services.SpectraGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSpectraParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'spec'", "'import'", "'weight'", "':'", "'-'", "'type'", "'='", "'define'", "':='", "'['", "']'", "'{'", "','", "'}'", "'regexp'", "'counter'", "'('", "')'", "'reset:'", "'inc:'", "'dec:'", "'overflow:'", "'underflow:'", "'monitor'", "'ini'", "'initially'", "'G'", "'trans'", "'always'", "'alw'", "'pattern'", "'var'", "'GF'", "'alwEv'", "'alwaysEventually'", "'predicate'", "'()'", "'boolean'", "'Int'", "'guarantee'", "'gar'", "'assumption'", "'asm'", "'GE'", "'GEF'", "'regtest'", "'not'", "'in'", "'->'", "'implies'", "'<->'", "'iff'", "'|'", "'or'", "'xor'", "'&'", "'and'", "'!='", "'<'", "'>'", "'<='", "'>='", "'mod'", "'%'", "'+'", "'*'", "'/'", "'S'", "'SINCE'", "'T'", "'TRIGGERED'", "'Y'", "'PREV'", "'H'", "'HISTORICALLY'", "'O'", "'ONCE'", "'!'", "'next'", "'.all'", "'.any'", "'.prod'", "'.sum'", "'.min'", "'.max'", "'..'", "'FALSE'", "'false'", "'TRUE'", "'true'", "'trig'", "'|=>'", "'?'", "'~'", "'forall'", "'exists'", "'.'", "';'", "'output'", "'out'", "'sysvar'", "'sys'", "'input'", "'envvar'", "'env'", "'auxvar'", "'aux'", "'keep'", "'modulo'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSpectraParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSpectraParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSpectraParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSpectra.g"; }



     	private SpectraGrammarAccess grammarAccess;

        public InternalSpectraParser(TokenStream input, SpectraGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SpectraGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSpectra.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSpectra.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalSpectra.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSpectra.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* (otherlv_1= 'module' | otherlv_2= 'spec' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_elements_4_0= ruleDecl ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_imports_0_0 = null;

        EObject lv_elements_4_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )* (otherlv_1= 'module' | otherlv_2= 'spec' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_elements_4_0= ruleDecl ) )+ ) )
            // InternalSpectra.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* (otherlv_1= 'module' | otherlv_2= 'spec' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_elements_4_0= ruleDecl ) )+ )
            {
            // InternalSpectra.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* (otherlv_1= 'module' | otherlv_2= 'spec' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_elements_4_0= ruleDecl ) )+ )
            // InternalSpectra.g:80:3: ( (lv_imports_0_0= ruleImport ) )* (otherlv_1= 'module' | otherlv_2= 'spec' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_elements_4_0= ruleDecl ) )+
            {
            // InternalSpectra.g:80:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSpectra.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalSpectra.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalSpectra.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"tau.smlab.syntech.Spectra.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalSpectra.g:99:3: (otherlv_1= 'module' | otherlv_2= 'spec' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalSpectra.g:100:4: otherlv_1= 'module'
                    {
                    otherlv_1=(Token)match(input,11,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getModelAccess().getModuleKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:105:4: otherlv_2= 'spec'
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getSpecKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:110:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalSpectra.g:111:4: (lv_name_3_0= RULE_ID )
            {
            // InternalSpectra.g:111:4: (lv_name_3_0= RULE_ID )
            // InternalSpectra.g:112:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_3_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSpectra.g:128:3: ( (lv_elements_4_0= ruleDecl ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14||LA3_0==17||LA3_0==19||(LA3_0>=26 && LA3_0<=27)||LA3_0==35||LA3_0==42||LA3_0==47||(LA3_0>=51 && LA3_0<=54)||LA3_0==57||LA3_0==59||(LA3_0>=110 && LA3_0<=118)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSpectra.g:129:4: (lv_elements_4_0= ruleDecl )
            	    {
            	    // InternalSpectra.g:129:4: (lv_elements_4_0= ruleDecl )
            	    // InternalSpectra.g:130:5: lv_elements_4_0= ruleDecl
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getElementsDeclParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_4_0=ruleDecl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_4_0,
            	    						"tau.smlab.syntech.Spectra.Decl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // InternalSpectra.g:151:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSpectra.g:151:47: (iv_ruleImport= ruleImport EOF )
            // InternalSpectra.g:152:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalSpectra.g:158:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalSpectra.g:164:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalSpectra.g:165:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalSpectra.g:165:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalSpectra.g:166:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSpectra.g:170:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalSpectra.g:171:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalSpectra.g:171:4: (lv_importURI_1_0= RULE_STRING )
            // InternalSpectra.g:172:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDecl"
    // InternalSpectra.g:192:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // InternalSpectra.g:192:45: (iv_ruleDecl= ruleDecl EOF )
            // InternalSpectra.g:193:2: iv_ruleDecl= ruleDecl EOF
            {
             newCompositeNode(grammarAccess.getDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecl=ruleDecl();

            state._fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // InternalSpectra.g:199:1: ruleDecl returns [EObject current=null] : (this_Var_0= ruleVar | this_TypeDef_1= ruleTypeDef | this_Define_2= ruleDefine | this_Predicate_3= rulePredicate | this_Pattern_4= rulePattern | this_Monitor_5= ruleMonitor | this_WeightDef_6= ruleWeightDef | this_LTLGar_7= ruleLTLGar | this_LTLAsm_8= ruleLTLAsm | this_EXGar_9= ruleEXGar | this_Counter_10= ruleCounter | this_DefineRegExp_11= ruleDefineRegExp | this_RegexpTest_12= ruleRegexpTest ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        EObject this_Var_0 = null;

        EObject this_TypeDef_1 = null;

        EObject this_Define_2 = null;

        EObject this_Predicate_3 = null;

        EObject this_Pattern_4 = null;

        EObject this_Monitor_5 = null;

        EObject this_WeightDef_6 = null;

        EObject this_LTLGar_7 = null;

        EObject this_LTLAsm_8 = null;

        EObject this_EXGar_9 = null;

        EObject this_Counter_10 = null;

        EObject this_DefineRegExp_11 = null;

        EObject this_RegexpTest_12 = null;



        	enterRule();

        try {
            // InternalSpectra.g:205:2: ( (this_Var_0= ruleVar | this_TypeDef_1= ruleTypeDef | this_Define_2= ruleDefine | this_Predicate_3= rulePredicate | this_Pattern_4= rulePattern | this_Monitor_5= ruleMonitor | this_WeightDef_6= ruleWeightDef | this_LTLGar_7= ruleLTLGar | this_LTLAsm_8= ruleLTLAsm | this_EXGar_9= ruleEXGar | this_Counter_10= ruleCounter | this_DefineRegExp_11= ruleDefineRegExp | this_RegexpTest_12= ruleRegexpTest ) )
            // InternalSpectra.g:206:2: (this_Var_0= ruleVar | this_TypeDef_1= ruleTypeDef | this_Define_2= ruleDefine | this_Predicate_3= rulePredicate | this_Pattern_4= rulePattern | this_Monitor_5= ruleMonitor | this_WeightDef_6= ruleWeightDef | this_LTLGar_7= ruleLTLGar | this_LTLAsm_8= ruleLTLAsm | this_EXGar_9= ruleEXGar | this_Counter_10= ruleCounter | this_DefineRegExp_11= ruleDefineRegExp | this_RegexpTest_12= ruleRegexpTest )
            {
            // InternalSpectra.g:206:2: (this_Var_0= ruleVar | this_TypeDef_1= ruleTypeDef | this_Define_2= ruleDefine | this_Predicate_3= rulePredicate | this_Pattern_4= rulePattern | this_Monitor_5= ruleMonitor | this_WeightDef_6= ruleWeightDef | this_LTLGar_7= ruleLTLGar | this_LTLAsm_8= ruleLTLAsm | this_EXGar_9= ruleEXGar | this_Counter_10= ruleCounter | this_DefineRegExp_11= ruleDefineRegExp | this_RegexpTest_12= ruleRegexpTest )
            int alt4=13;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalSpectra.g:207:3: this_Var_0= ruleVar
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getVarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Var_0=ruleVar();

                    state._fsp--;


                    			current = this_Var_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:216:3: this_TypeDef_1= ruleTypeDef
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getTypeDefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TypeDef_1=ruleTypeDef();

                    state._fsp--;


                    			current = this_TypeDef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSpectra.g:225:3: this_Define_2= ruleDefine
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getDefineParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Define_2=ruleDefine();

                    state._fsp--;


                    			current = this_Define_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSpectra.g:234:3: this_Predicate_3= rulePredicate
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getPredicateParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Predicate_3=rulePredicate();

                    state._fsp--;


                    			current = this_Predicate_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSpectra.g:243:3: this_Pattern_4= rulePattern
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getPatternParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Pattern_4=rulePattern();

                    state._fsp--;


                    			current = this_Pattern_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSpectra.g:252:3: this_Monitor_5= ruleMonitor
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getMonitorParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Monitor_5=ruleMonitor();

                    state._fsp--;


                    			current = this_Monitor_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSpectra.g:261:3: this_WeightDef_6= ruleWeightDef
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getWeightDefParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_WeightDef_6=ruleWeightDef();

                    state._fsp--;


                    			current = this_WeightDef_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSpectra.g:270:3: this_LTLGar_7= ruleLTLGar
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getLTLGarParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_LTLGar_7=ruleLTLGar();

                    state._fsp--;


                    			current = this_LTLGar_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalSpectra.g:279:3: this_LTLAsm_8= ruleLTLAsm
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getLTLAsmParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_LTLAsm_8=ruleLTLAsm();

                    state._fsp--;


                    			current = this_LTLAsm_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalSpectra.g:288:3: this_EXGar_9= ruleEXGar
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getEXGarParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_EXGar_9=ruleEXGar();

                    state._fsp--;


                    			current = this_EXGar_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalSpectra.g:297:3: this_Counter_10= ruleCounter
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getCounterParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_Counter_10=ruleCounter();

                    state._fsp--;


                    			current = this_Counter_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalSpectra.g:306:3: this_DefineRegExp_11= ruleDefineRegExp
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getDefineRegExpParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_DefineRegExp_11=ruleDefineRegExp();

                    state._fsp--;


                    			current = this_DefineRegExp_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalSpectra.g:315:3: this_RegexpTest_12= ruleRegexpTest
                    {

                    			newCompositeNode(grammarAccess.getDeclAccess().getRegexpTestParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegexpTest_12=ruleRegexpTest();

                    state._fsp--;


                    			current = this_RegexpTest_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleWeightDef"
    // InternalSpectra.g:327:1: entryRuleWeightDef returns [EObject current=null] : iv_ruleWeightDef= ruleWeightDef EOF ;
    public final EObject entryRuleWeightDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWeightDef = null;


        try {
            // InternalSpectra.g:327:50: (iv_ruleWeightDef= ruleWeightDef EOF )
            // InternalSpectra.g:328:2: iv_ruleWeightDef= ruleWeightDef EOF
            {
             newCompositeNode(grammarAccess.getWeightDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWeightDef=ruleWeightDef();

            state._fsp--;

             current =iv_ruleWeightDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWeightDef"


    // $ANTLR start "ruleWeightDef"
    // InternalSpectra.g:334:1: ruleWeightDef returns [EObject current=null] : (otherlv_0= 'weight' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( (lv_negative_3_0= '-' ) )? ( (lv_value_4_0= RULE_INT ) ) ( (lv_definition_5_0= ruleTemporalInExpr ) ) ruleTOK_SEMI ) ;
    public final EObject ruleWeightDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_negative_3_0=null;
        Token lv_value_4_0=null;
        EObject lv_definition_5_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:340:2: ( (otherlv_0= 'weight' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( (lv_negative_3_0= '-' ) )? ( (lv_value_4_0= RULE_INT ) ) ( (lv_definition_5_0= ruleTemporalInExpr ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:341:2: (otherlv_0= 'weight' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( (lv_negative_3_0= '-' ) )? ( (lv_value_4_0= RULE_INT ) ) ( (lv_definition_5_0= ruleTemporalInExpr ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:341:2: (otherlv_0= 'weight' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( (lv_negative_3_0= '-' ) )? ( (lv_value_4_0= RULE_INT ) ) ( (lv_definition_5_0= ruleTemporalInExpr ) ) ruleTOK_SEMI )
            // InternalSpectra.g:342:3: otherlv_0= 'weight' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( (lv_negative_3_0= '-' ) )? ( (lv_value_4_0= RULE_INT ) ) ( (lv_definition_5_0= ruleTemporalInExpr ) ) ruleTOK_SEMI
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getWeightDefAccess().getWeightKeyword_0());
            		
            // InternalSpectra.g:346:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSpectra.g:347:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':'
                    {
                    // InternalSpectra.g:347:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpectra.g:348:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpectra.g:348:5: (lv_name_1_0= RULE_ID )
                    // InternalSpectra.g:349:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getWeightDefAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getWeightDefRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getWeightDefAccess().getColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:370:3: ( (lv_negative_3_0= '-' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSpectra.g:371:4: (lv_negative_3_0= '-' )
                    {
                    // InternalSpectra.g:371:4: (lv_negative_3_0= '-' )
                    // InternalSpectra.g:372:5: lv_negative_3_0= '-'
                    {
                    lv_negative_3_0=(Token)match(input,16,FOLLOW_11); 

                    					newLeafNode(lv_negative_3_0, grammarAccess.getWeightDefAccess().getNegativeHyphenMinusKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWeightDefRule());
                    					}
                    					setWithLastConsumed(current, "negative", lv_negative_3_0, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalSpectra.g:384:3: ( (lv_value_4_0= RULE_INT ) )
            // InternalSpectra.g:385:4: (lv_value_4_0= RULE_INT )
            {
            // InternalSpectra.g:385:4: (lv_value_4_0= RULE_INT )
            // InternalSpectra.g:386:5: lv_value_4_0= RULE_INT
            {
            lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_value_4_0, grammarAccess.getWeightDefAccess().getValueINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWeightDefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalSpectra.g:402:3: ( (lv_definition_5_0= ruleTemporalInExpr ) )
            // InternalSpectra.g:403:4: (lv_definition_5_0= ruleTemporalInExpr )
            {
            // InternalSpectra.g:403:4: (lv_definition_5_0= ruleTemporalInExpr )
            // InternalSpectra.g:404:5: lv_definition_5_0= ruleTemporalInExpr
            {

            					newCompositeNode(grammarAccess.getWeightDefAccess().getDefinitionTemporalInExprParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_13);
            lv_definition_5_0=ruleTemporalInExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWeightDefRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_5_0,
            						"tau.smlab.syntech.Spectra.TemporalInExpr");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            			newCompositeNode(grammarAccess.getWeightDefAccess().getTOK_SEMIParserRuleCall_5());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWeightDef"


    // $ANTLR start "entryRuleVar"
    // InternalSpectra.g:432:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalSpectra.g:432:44: (iv_ruleVar= ruleVar EOF )
            // InternalSpectra.g:433:2: iv_ruleVar= ruleVar EOF
            {
             newCompositeNode(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVar=ruleVar();

            state._fsp--;

             current =iv_ruleVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // InternalSpectra.g:439:1: ruleVar returns [EObject current=null] : ( ( (lv_kind_0_0= ruleVarOwner ) ) ( (lv_var_1_0= ruleVarDecl ) ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Enumerator lv_kind_0_0 = null;

        EObject lv_var_1_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:445:2: ( ( ( (lv_kind_0_0= ruleVarOwner ) ) ( (lv_var_1_0= ruleVarDecl ) ) ) )
            // InternalSpectra.g:446:2: ( ( (lv_kind_0_0= ruleVarOwner ) ) ( (lv_var_1_0= ruleVarDecl ) ) )
            {
            // InternalSpectra.g:446:2: ( ( (lv_kind_0_0= ruleVarOwner ) ) ( (lv_var_1_0= ruleVarDecl ) ) )
            // InternalSpectra.g:447:3: ( (lv_kind_0_0= ruleVarOwner ) ) ( (lv_var_1_0= ruleVarDecl ) )
            {
            // InternalSpectra.g:447:3: ( (lv_kind_0_0= ruleVarOwner ) )
            // InternalSpectra.g:448:4: (lv_kind_0_0= ruleVarOwner )
            {
            // InternalSpectra.g:448:4: (lv_kind_0_0= ruleVarOwner )
            // InternalSpectra.g:449:5: lv_kind_0_0= ruleVarOwner
            {

            					newCompositeNode(grammarAccess.getVarAccess().getKindVarOwnerEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_14);
            lv_kind_0_0=ruleVarOwner();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"tau.smlab.syntech.Spectra.VarOwner");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:466:3: ( (lv_var_1_0= ruleVarDecl ) )
            // InternalSpectra.g:467:4: (lv_var_1_0= ruleVarDecl )
            {
            // InternalSpectra.g:467:4: (lv_var_1_0= ruleVarDecl )
            // InternalSpectra.g:468:5: lv_var_1_0= ruleVarDecl
            {

            					newCompositeNode(grammarAccess.getVarAccess().getVarVarDeclParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_var_1_0=ruleVarDecl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarRule());
            					}
            					set(
            						current,
            						"var",
            						lv_var_1_0,
            						"tau.smlab.syntech.Spectra.VarDecl");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleTypeDef"
    // InternalSpectra.g:489:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalSpectra.g:489:48: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalSpectra.g:490:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
             newCompositeNode(grammarAccess.getTypeDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;

             current =iv_ruleTypeDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDef"


    // $ANTLR start "ruleTypeDef"
    // InternalSpectra.g:496:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleVarType ) ) ruleTOK_SEMI ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:502:2: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleVarType ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:503:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleVarType ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:503:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleVarType ) ) ruleTOK_SEMI )
            // InternalSpectra.g:504:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= ruleVarType ) ) ruleTOK_SEMI
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypeKeyword_0());
            		
            // InternalSpectra.g:508:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:509:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:509:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:510:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeDefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTypeDefAccess().getEqualsSignKeyword_2());
            		
            // InternalSpectra.g:530:3: ( (lv_type_3_0= ruleVarType ) )
            // InternalSpectra.g:531:4: (lv_type_3_0= ruleVarType )
            {
            // InternalSpectra.g:531:4: (lv_type_3_0= ruleVarType )
            // InternalSpectra.g:532:5: lv_type_3_0= ruleVarType
            {

            					newCompositeNode(grammarAccess.getTypeDefAccess().getTypeVarTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_13);
            lv_type_3_0=ruleVarType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypeDefRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"tau.smlab.syntech.Spectra.VarType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            			newCompositeNode(grammarAccess.getTypeDefAccess().getTOK_SEMIParserRuleCall_4());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDef"


    // $ANTLR start "entryRuleVarDecl"
    // InternalSpectra.g:560:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalSpectra.g:560:48: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalSpectra.g:561:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
             newCompositeNode(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;

             current =iv_ruleVarDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalSpectra.g:567:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ruleTOK_SEMI ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:573:2: ( ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:574:2: ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:574:2: ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ruleTOK_SEMI )
            // InternalSpectra.g:575:3: ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:575:3: ( (lv_type_0_0= ruleVarType ) )
            // InternalSpectra.g:576:4: (lv_type_0_0= ruleVarType )
            {
            // InternalSpectra.g:576:4: (lv_type_0_0= ruleVarType )
            // InternalSpectra.g:577:5: lv_type_0_0= ruleVarType
            {

            					newCompositeNode(grammarAccess.getVarDeclAccess().getTypeVarTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleVarType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarDeclRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"tau.smlab.syntech.Spectra.VarType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:594:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:595:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:595:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:596:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVarDeclRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getVarDeclAccess().getTOK_SEMIParserRuleCall_2());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleTypeConstant"
    // InternalSpectra.g:623:1: entryRuleTypeConstant returns [EObject current=null] : iv_ruleTypeConstant= ruleTypeConstant EOF ;
    public final EObject entryRuleTypeConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConstant = null;


        try {
            // InternalSpectra.g:623:53: (iv_ruleTypeConstant= ruleTypeConstant EOF )
            // InternalSpectra.g:624:2: iv_ruleTypeConstant= ruleTypeConstant EOF
            {
             newCompositeNode(grammarAccess.getTypeConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeConstant=ruleTypeConstant();

            state._fsp--;

             current =iv_ruleTypeConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConstant"


    // $ANTLR start "ruleTypeConstant"
    // InternalSpectra.g:630:1: ruleTypeConstant returns [EObject current=null] : ( (lv_name_0_0= ruleTypeConstantLiteral ) ) ;
    public final EObject ruleTypeConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:636:2: ( ( (lv_name_0_0= ruleTypeConstantLiteral ) ) )
            // InternalSpectra.g:637:2: ( (lv_name_0_0= ruleTypeConstantLiteral ) )
            {
            // InternalSpectra.g:637:2: ( (lv_name_0_0= ruleTypeConstantLiteral ) )
            // InternalSpectra.g:638:3: (lv_name_0_0= ruleTypeConstantLiteral )
            {
            // InternalSpectra.g:638:3: (lv_name_0_0= ruleTypeConstantLiteral )
            // InternalSpectra.g:639:4: lv_name_0_0= ruleTypeConstantLiteral
            {

            				newCompositeNode(grammarAccess.getTypeConstantAccess().getNameTypeConstantLiteralParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleTypeConstantLiteral();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getTypeConstantRule());
            				}
            				set(
            					current,
            					"name",
            					lv_name_0_0,
            					"tau.smlab.syntech.Spectra.TypeConstantLiteral");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConstant"


    // $ANTLR start "entryRuleTypeConstantLiteral"
    // InternalSpectra.g:659:1: entryRuleTypeConstantLiteral returns [String current=null] : iv_ruleTypeConstantLiteral= ruleTypeConstantLiteral EOF ;
    public final String entryRuleTypeConstantLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTypeConstantLiteral = null;


        try {
            // InternalSpectra.g:659:59: (iv_ruleTypeConstantLiteral= ruleTypeConstantLiteral EOF )
            // InternalSpectra.g:660:2: iv_ruleTypeConstantLiteral= ruleTypeConstantLiteral EOF
            {
             newCompositeNode(grammarAccess.getTypeConstantLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeConstantLiteral=ruleTypeConstantLiteral();

            state._fsp--;

             current =iv_ruleTypeConstantLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConstantLiteral"


    // $ANTLR start "ruleTypeConstantLiteral"
    // InternalSpectra.g:666:1: ruleTypeConstantLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTypeConstantLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalSpectra.g:672:2: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT ) )
            // InternalSpectra.g:673:2: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            {
            // InternalSpectra.g:673:2: (this_ID_0= RULE_ID | this_INT_1= RULE_INT )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSpectra.g:674:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getTypeConstantLiteralAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:682:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getTypeConstantLiteralAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConstantLiteral"


    // $ANTLR start "entryRuleDefine"
    // InternalSpectra.g:693:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // InternalSpectra.g:693:47: (iv_ruleDefine= ruleDefine EOF )
            // InternalSpectra.g:694:2: iv_ruleDefine= ruleDefine EOF
            {
             newCompositeNode(grammarAccess.getDefineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefine=ruleDefine();

            state._fsp--;

             current =iv_ruleDefine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefine"


    // $ANTLR start "ruleDefine"
    // InternalSpectra.g:700:1: ruleDefine returns [EObject current=null] : (otherlv_0= 'define' ( (lv_defineList_1_0= ruleDefineDecl ) )+ ) ;
    public final EObject ruleDefine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_defineList_1_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:706:2: ( (otherlv_0= 'define' ( (lv_defineList_1_0= ruleDefineDecl ) )+ ) )
            // InternalSpectra.g:707:2: (otherlv_0= 'define' ( (lv_defineList_1_0= ruleDefineDecl ) )+ )
            {
            // InternalSpectra.g:707:2: (otherlv_0= 'define' ( (lv_defineList_1_0= ruleDefineDecl ) )+ )
            // InternalSpectra.g:708:3: otherlv_0= 'define' ( (lv_defineList_1_0= ruleDefineDecl ) )+
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDefineAccess().getDefineKeyword_0());
            		
            // InternalSpectra.g:712:3: ( (lv_defineList_1_0= ruleDefineDecl ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSpectra.g:713:4: (lv_defineList_1_0= ruleDefineDecl )
            	    {
            	    // InternalSpectra.g:713:4: (lv_defineList_1_0= ruleDefineDecl )
            	    // InternalSpectra.g:714:5: lv_defineList_1_0= ruleDefineDecl
            	    {

            	    					newCompositeNode(grammarAccess.getDefineAccess().getDefineListDefineDeclParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_defineList_1_0=ruleDefineDecl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDefineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"defineList",
            	    						lv_defineList_1_0,
            	    						"tau.smlab.syntech.Spectra.DefineDecl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefine"


    // $ANTLR start "entryRuleDefineDecl"
    // InternalSpectra.g:735:1: entryRuleDefineDecl returns [EObject current=null] : iv_ruleDefineDecl= ruleDefineDecl EOF ;
    public final EObject entryRuleDefineDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDecl = null;


        try {
            // InternalSpectra.g:735:51: (iv_ruleDefineDecl= ruleDefineDecl EOF )
            // InternalSpectra.g:736:2: iv_ruleDefineDecl= ruleDefineDecl EOF
            {
             newCompositeNode(grammarAccess.getDefineDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefineDecl=ruleDefineDecl();

            state._fsp--;

             current =iv_ruleDefineDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefineDecl"


    // $ANTLR start "ruleDefineDecl"
    // InternalSpectra.g:742:1: ruleDefineDecl returns [EObject current=null] : ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) ) ruleTOK_SEMI ) ;
    public final EObject ruleDefineDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_simpleExpr_2_0 = null;

        EObject lv_dimensions_5_0 = null;

        EObject lv_innerArray_8_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:748:2: ( ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:749:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:749:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) ) ruleTOK_SEMI )
            // InternalSpectra.g:750:3: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:750:3: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) ) | ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==21) ) {
                    alt10=2;
                }
                else if ( (LA10_1==20) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalSpectra.g:751:4: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) )
                    {
                    // InternalSpectra.g:751:4: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) ) )
                    // InternalSpectra.g:752:5: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_simpleExpr_2_0= ruleTemporalExpression ) )
                    {
                    // InternalSpectra.g:752:5: ( (lv_name_0_0= RULE_ID ) )
                    // InternalSpectra.g:753:6: (lv_name_0_0= RULE_ID )
                    {
                    // InternalSpectra.g:753:6: (lv_name_0_0= RULE_ID )
                    // InternalSpectra.g:754:7: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

                    							newLeafNode(lv_name_0_0, grammarAccess.getDefineDeclAccess().getNameIDTerminalRuleCall_0_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDefineDeclRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_0_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    otherlv_1=(Token)match(input,20,FOLLOW_18); 

                    					newLeafNode(otherlv_1, grammarAccess.getDefineDeclAccess().getColonEqualsSignKeyword_0_0_1());
                    				
                    // InternalSpectra.g:774:5: ( (lv_simpleExpr_2_0= ruleTemporalExpression ) )
                    // InternalSpectra.g:775:6: (lv_simpleExpr_2_0= ruleTemporalExpression )
                    {
                    // InternalSpectra.g:775:6: (lv_simpleExpr_2_0= ruleTemporalExpression )
                    // InternalSpectra.g:776:7: lv_simpleExpr_2_0= ruleTemporalExpression
                    {

                    							newCompositeNode(grammarAccess.getDefineDeclAccess().getSimpleExprTemporalExpressionParserRuleCall_0_0_2_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_simpleExpr_2_0=ruleTemporalExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDefineDeclRule());
                    							}
                    							set(
                    								current,
                    								"simpleExpr",
                    								lv_simpleExpr_2_0,
                    								"tau.smlab.syntech.Spectra.TemporalExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:795:4: ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) )
                    {
                    // InternalSpectra.g:795:4: ( ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) ) )
                    // InternalSpectra.g:796:5: ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+ otherlv_7= ':=' ( (lv_innerArray_8_0= ruleDefineArray ) )
                    {
                    // InternalSpectra.g:796:5: ( (lv_name_3_0= RULE_ID ) )
                    // InternalSpectra.g:797:6: (lv_name_3_0= RULE_ID )
                    {
                    // InternalSpectra.g:797:6: (lv_name_3_0= RULE_ID )
                    // InternalSpectra.g:798:7: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    							newLeafNode(lv_name_3_0, grammarAccess.getDefineDeclAccess().getNameIDTerminalRuleCall_0_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getDefineDeclRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_3_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    // InternalSpectra.g:814:5: (otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalSpectra.g:815:6: otherlv_4= '[' ( (lv_dimensions_5_0= ruleSizeDefineDecl ) ) otherlv_6= ']'
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_20); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getDefineDeclAccess().getLeftSquareBracketKeyword_0_1_1_0());
                    	    					
                    	    // InternalSpectra.g:819:6: ( (lv_dimensions_5_0= ruleSizeDefineDecl ) )
                    	    // InternalSpectra.g:820:7: (lv_dimensions_5_0= ruleSizeDefineDecl )
                    	    {
                    	    // InternalSpectra.g:820:7: (lv_dimensions_5_0= ruleSizeDefineDecl )
                    	    // InternalSpectra.g:821:8: lv_dimensions_5_0= ruleSizeDefineDecl
                    	    {

                    	    								newCompositeNode(grammarAccess.getDefineDeclAccess().getDimensionsSizeDefineDeclParserRuleCall_0_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_21);
                    	    lv_dimensions_5_0=ruleSizeDefineDecl();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDefineDeclRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"dimensions",
                    	    									lv_dimensions_5_0,
                    	    									"tau.smlab.syntech.Spectra.SizeDefineDecl");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }

                    	    otherlv_6=(Token)match(input,22,FOLLOW_22); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getDefineDeclAccess().getRightSquareBracketKeyword_0_1_1_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_23); 

                    					newLeafNode(otherlv_7, grammarAccess.getDefineDeclAccess().getColonEqualsSignKeyword_0_1_2());
                    				
                    // InternalSpectra.g:847:5: ( (lv_innerArray_8_0= ruleDefineArray ) )
                    // InternalSpectra.g:848:6: (lv_innerArray_8_0= ruleDefineArray )
                    {
                    // InternalSpectra.g:848:6: (lv_innerArray_8_0= ruleDefineArray )
                    // InternalSpectra.g:849:7: lv_innerArray_8_0= ruleDefineArray
                    {

                    							newCompositeNode(grammarAccess.getDefineDeclAccess().getInnerArrayDefineArrayParserRuleCall_0_1_3_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_innerArray_8_0=ruleDefineArray();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDefineDeclRule());
                    							}
                    							set(
                    								current,
                    								"innerArray",
                    								lv_innerArray_8_0,
                    								"tau.smlab.syntech.Spectra.DefineArray");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getDefineDeclAccess().getTOK_SEMIParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefineDecl"


    // $ANTLR start "entryRuleDefineArray"
    // InternalSpectra.g:879:1: entryRuleDefineArray returns [EObject current=null] : iv_ruleDefineArray= ruleDefineArray EOF ;
    public final EObject entryRuleDefineArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineArray = null;


        try {
            // InternalSpectra.g:879:52: (iv_ruleDefineArray= ruleDefineArray EOF )
            // InternalSpectra.g:880:2: iv_ruleDefineArray= ruleDefineArray EOF
            {
             newCompositeNode(grammarAccess.getDefineArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefineArray=ruleDefineArray();

            state._fsp--;

             current =iv_ruleDefineArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefineArray"


    // $ANTLR start "ruleDefineArray"
    // InternalSpectra.g:886:1: ruleDefineArray returns [EObject current=null] : ( (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' ) | (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' ) ) ;
    public final EObject ruleDefineArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_simpleExprs_1_0 = null;

        EObject lv_simpleExprs_3_0 = null;

        EObject lv_innerArrays_6_0 = null;

        EObject lv_innerArrays_8_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:892:2: ( ( (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' ) | (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' ) ) )
            // InternalSpectra.g:893:2: ( (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' ) | (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' ) )
            {
            // InternalSpectra.g:893:2: ( (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' ) | (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==23) ) {
                    alt13=2;
                }
                else if ( (LA13_1==RULE_ID||LA13_1==RULE_INT||LA13_1==16||LA13_1==26||LA13_1==28||(LA13_1>=83 && LA13_1<=90)||(LA13_1>=98 && LA13_1<=101)||(LA13_1>=106 && LA13_1<=107)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSpectra.g:894:3: (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' )
                    {
                    // InternalSpectra.g:894:3: (otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}' )
                    // InternalSpectra.g:895:4: otherlv_0= '{' ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* ) otherlv_4= '}'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_0, grammarAccess.getDefineArrayAccess().getLeftCurlyBracketKeyword_0_0());
                    			
                    // InternalSpectra.g:899:4: ( ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )* )
                    // InternalSpectra.g:900:5: ( (lv_simpleExprs_1_0= ruleTemporalExpression ) ) (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )*
                    {
                    // InternalSpectra.g:900:5: ( (lv_simpleExprs_1_0= ruleTemporalExpression ) )
                    // InternalSpectra.g:901:6: (lv_simpleExprs_1_0= ruleTemporalExpression )
                    {
                    // InternalSpectra.g:901:6: (lv_simpleExprs_1_0= ruleTemporalExpression )
                    // InternalSpectra.g:902:7: lv_simpleExprs_1_0= ruleTemporalExpression
                    {

                    							newCompositeNode(grammarAccess.getDefineArrayAccess().getSimpleExprsTemporalExpressionParserRuleCall_0_1_0_0());
                    						
                    pushFollow(FOLLOW_24);
                    lv_simpleExprs_1_0=ruleTemporalExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDefineArrayRule());
                    							}
                    							add(
                    								current,
                    								"simpleExprs",
                    								lv_simpleExprs_1_0,
                    								"tau.smlab.syntech.Spectra.TemporalExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalSpectra.g:919:5: (otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==24) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalSpectra.g:920:6: otherlv_2= ',' ( (lv_simpleExprs_3_0= ruleTemporalExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,24,FOLLOW_18); 

                    	    						newLeafNode(otherlv_2, grammarAccess.getDefineArrayAccess().getCommaKeyword_0_1_1_0());
                    	    					
                    	    // InternalSpectra.g:924:6: ( (lv_simpleExprs_3_0= ruleTemporalExpression ) )
                    	    // InternalSpectra.g:925:7: (lv_simpleExprs_3_0= ruleTemporalExpression )
                    	    {
                    	    // InternalSpectra.g:925:7: (lv_simpleExprs_3_0= ruleTemporalExpression )
                    	    // InternalSpectra.g:926:8: lv_simpleExprs_3_0= ruleTemporalExpression
                    	    {

                    	    								newCompositeNode(grammarAccess.getDefineArrayAccess().getSimpleExprsTemporalExpressionParserRuleCall_0_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_24);
                    	    lv_simpleExprs_3_0=ruleTemporalExpression();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDefineArrayRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"simpleExprs",
                    	    									lv_simpleExprs_3_0,
                    	    									"tau.smlab.syntech.Spectra.TemporalExpression");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getDefineArrayAccess().getRightCurlyBracketKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:951:3: (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' )
                    {
                    // InternalSpectra.g:951:3: (otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}' )
                    // InternalSpectra.g:952:4: otherlv_5= '{' ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* ) otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getDefineArrayAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalSpectra.g:956:4: ( ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )* )
                    // InternalSpectra.g:957:5: ( (lv_innerArrays_6_0= ruleDefineArray ) ) (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )*
                    {
                    // InternalSpectra.g:957:5: ( (lv_innerArrays_6_0= ruleDefineArray ) )
                    // InternalSpectra.g:958:6: (lv_innerArrays_6_0= ruleDefineArray )
                    {
                    // InternalSpectra.g:958:6: (lv_innerArrays_6_0= ruleDefineArray )
                    // InternalSpectra.g:959:7: lv_innerArrays_6_0= ruleDefineArray
                    {

                    							newCompositeNode(grammarAccess.getDefineArrayAccess().getInnerArraysDefineArrayParserRuleCall_1_1_0_0());
                    						
                    pushFollow(FOLLOW_24);
                    lv_innerArrays_6_0=ruleDefineArray();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDefineArrayRule());
                    							}
                    							add(
                    								current,
                    								"innerArrays",
                    								lv_innerArrays_6_0,
                    								"tau.smlab.syntech.Spectra.DefineArray");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalSpectra.g:976:5: (otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==24) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSpectra.g:977:6: otherlv_7= ',' ( (lv_innerArrays_8_0= ruleDefineArray ) )
                    	    {
                    	    otherlv_7=(Token)match(input,24,FOLLOW_23); 

                    	    						newLeafNode(otherlv_7, grammarAccess.getDefineArrayAccess().getCommaKeyword_1_1_1_0());
                    	    					
                    	    // InternalSpectra.g:981:6: ( (lv_innerArrays_8_0= ruleDefineArray ) )
                    	    // InternalSpectra.g:982:7: (lv_innerArrays_8_0= ruleDefineArray )
                    	    {
                    	    // InternalSpectra.g:982:7: (lv_innerArrays_8_0= ruleDefineArray )
                    	    // InternalSpectra.g:983:8: lv_innerArrays_8_0= ruleDefineArray
                    	    {

                    	    								newCompositeNode(grammarAccess.getDefineArrayAccess().getInnerArraysDefineArrayParserRuleCall_1_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_24);
                    	    lv_innerArrays_8_0=ruleDefineArray();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDefineArrayRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"innerArrays",
                    	    									lv_innerArrays_8_0,
                    	    									"tau.smlab.syntech.Spectra.DefineArray");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }

                    otherlv_9=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getDefineArrayAccess().getRightCurlyBracketKeyword_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefineArray"


    // $ANTLR start "entryRuleDefineRegExp"
    // InternalSpectra.g:1011:1: entryRuleDefineRegExp returns [EObject current=null] : iv_ruleDefineRegExp= ruleDefineRegExp EOF ;
    public final EObject entryRuleDefineRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineRegExp = null;


        try {
            // InternalSpectra.g:1011:53: (iv_ruleDefineRegExp= ruleDefineRegExp EOF )
            // InternalSpectra.g:1012:2: iv_ruleDefineRegExp= ruleDefineRegExp EOF
            {
             newCompositeNode(grammarAccess.getDefineRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefineRegExp=ruleDefineRegExp();

            state._fsp--;

             current =iv_ruleDefineRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefineRegExp"


    // $ANTLR start "ruleDefineRegExp"
    // InternalSpectra.g:1018:1: ruleDefineRegExp returns [EObject current=null] : (otherlv_0= 'regexp' ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+ ) ;
    public final EObject ruleDefineRegExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_defineRegsList_1_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1024:2: ( (otherlv_0= 'regexp' ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+ ) )
            // InternalSpectra.g:1025:2: (otherlv_0= 'regexp' ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+ )
            {
            // InternalSpectra.g:1025:2: (otherlv_0= 'regexp' ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+ )
            // InternalSpectra.g:1026:3: otherlv_0= 'regexp' ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDefineRegExpAccess().getRegexpKeyword_0());
            		
            // InternalSpectra.g:1030:3: ( (lv_defineRegsList_1_0= ruleDefineRegExpDecl ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSpectra.g:1031:4: (lv_defineRegsList_1_0= ruleDefineRegExpDecl )
            	    {
            	    // InternalSpectra.g:1031:4: (lv_defineRegsList_1_0= ruleDefineRegExpDecl )
            	    // InternalSpectra.g:1032:5: lv_defineRegsList_1_0= ruleDefineRegExpDecl
            	    {

            	    					newCompositeNode(grammarAccess.getDefineRegExpAccess().getDefineRegsListDefineRegExpDeclParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_defineRegsList_1_0=ruleDefineRegExpDecl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDefineRegExpRule());
            	    					}
            	    					add(
            	    						current,
            	    						"defineRegsList",
            	    						lv_defineRegsList_1_0,
            	    						"tau.smlab.syntech.Spectra.DefineRegExpDecl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefineRegExp"


    // $ANTLR start "entryRuleDefineRegExpDecl"
    // InternalSpectra.g:1053:1: entryRuleDefineRegExpDecl returns [EObject current=null] : iv_ruleDefineRegExpDecl= ruleDefineRegExpDecl EOF ;
    public final EObject entryRuleDefineRegExpDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineRegExpDecl = null;


        try {
            // InternalSpectra.g:1053:57: (iv_ruleDefineRegExpDecl= ruleDefineRegExpDecl EOF )
            // InternalSpectra.g:1054:2: iv_ruleDefineRegExpDecl= ruleDefineRegExpDecl EOF
            {
             newCompositeNode(grammarAccess.getDefineRegExpDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefineRegExpDecl=ruleDefineRegExpDecl();

            state._fsp--;

             current =iv_ruleDefineRegExpDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefineRegExpDecl"


    // $ANTLR start "ruleDefineRegExpDecl"
    // InternalSpectra.g:1060:1: ruleDefineRegExpDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_exp_2_0= ruleRegExp ) ) ruleTOK_SEMI ) ;
    public final EObject ruleDefineRegExpDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1066:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_exp_2_0= ruleRegExp ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:1067:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_exp_2_0= ruleRegExp ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:1067:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_exp_2_0= ruleRegExp ) ) ruleTOK_SEMI )
            // InternalSpectra.g:1068:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_exp_2_0= ruleRegExp ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:1068:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpectra.g:1069:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSpectra.g:1069:4: (lv_name_0_0= RULE_ID )
            // InternalSpectra.g:1070:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDefineRegExpDeclAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefineRegExpDeclRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getDefineRegExpDeclAccess().getColonEqualsSignKeyword_1());
            		
            // InternalSpectra.g:1090:3: ( (lv_exp_2_0= ruleRegExp ) )
            // InternalSpectra.g:1091:4: (lv_exp_2_0= ruleRegExp )
            {
            // InternalSpectra.g:1091:4: (lv_exp_2_0= ruleRegExp )
            // InternalSpectra.g:1092:5: lv_exp_2_0= ruleRegExp
            {

            					newCompositeNode(grammarAccess.getDefineRegExpDeclAccess().getExpRegExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
            lv_exp_2_0=ruleRegExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefineRegExpDeclRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"tau.smlab.syntech.Spectra.RegExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            			newCompositeNode(grammarAccess.getDefineRegExpDeclAccess().getTOK_SEMIParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefineRegExpDecl"


    // $ANTLR start "entryRulePatternParamList"
    // InternalSpectra.g:1120:1: entryRulePatternParamList returns [EObject current=null] : iv_rulePatternParamList= rulePatternParamList EOF ;
    public final EObject entryRulePatternParamList() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternParamList = null;


        try {
            // InternalSpectra.g:1120:57: (iv_rulePatternParamList= rulePatternParamList EOF )
            // InternalSpectra.g:1121:2: iv_rulePatternParamList= rulePatternParamList EOF
            {
             newCompositeNode(grammarAccess.getPatternParamListRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternParamList=rulePatternParamList();

            state._fsp--;

             current =iv_rulePatternParamList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternParamList"


    // $ANTLR start "rulePatternParamList"
    // InternalSpectra.g:1127:1: rulePatternParamList returns [EObject current=null] : ( ( (lv_params_0_0= rulePatternParam ) ) (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )* ) ;
    public final EObject rulePatternParamList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1133:2: ( ( ( (lv_params_0_0= rulePatternParam ) ) (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )* ) )
            // InternalSpectra.g:1134:2: ( ( (lv_params_0_0= rulePatternParam ) ) (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )* )
            {
            // InternalSpectra.g:1134:2: ( ( (lv_params_0_0= rulePatternParam ) ) (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )* )
            // InternalSpectra.g:1135:3: ( (lv_params_0_0= rulePatternParam ) ) (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )*
            {
            // InternalSpectra.g:1135:3: ( (lv_params_0_0= rulePatternParam ) )
            // InternalSpectra.g:1136:4: (lv_params_0_0= rulePatternParam )
            {
            // InternalSpectra.g:1136:4: (lv_params_0_0= rulePatternParam )
            // InternalSpectra.g:1137:5: lv_params_0_0= rulePatternParam
            {

            					newCompositeNode(grammarAccess.getPatternParamListAccess().getParamsPatternParamParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_params_0_0=rulePatternParam();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPatternParamListRule());
            					}
            					add(
            						current,
            						"params",
            						lv_params_0_0,
            						"tau.smlab.syntech.Spectra.PatternParam");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:1154:3: (otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSpectra.g:1155:4: otherlv_1= ',' ( (lv_params_2_0= rulePatternParam ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPatternParamListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalSpectra.g:1159:4: ( (lv_params_2_0= rulePatternParam ) )
            	    // InternalSpectra.g:1160:5: (lv_params_2_0= rulePatternParam )
            	    {
            	    // InternalSpectra.g:1160:5: (lv_params_2_0= rulePatternParam )
            	    // InternalSpectra.g:1161:6: lv_params_2_0= rulePatternParam
            	    {

            	    						newCompositeNode(grammarAccess.getPatternParamListAccess().getParamsPatternParamParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_params_2_0=rulePatternParam();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPatternParamListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"params",
            	    							lv_params_2_0,
            	    							"tau.smlab.syntech.Spectra.PatternParam");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternParamList"


    // $ANTLR start "entryRulePatternParam"
    // InternalSpectra.g:1183:1: entryRulePatternParam returns [EObject current=null] : iv_rulePatternParam= rulePatternParam EOF ;
    public final EObject entryRulePatternParam() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternParam = null;


        try {
            // InternalSpectra.g:1183:53: (iv_rulePatternParam= rulePatternParam EOF )
            // InternalSpectra.g:1184:2: iv_rulePatternParam= rulePatternParam EOF
            {
             newCompositeNode(grammarAccess.getPatternParamRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternParam=rulePatternParam();

            state._fsp--;

             current =iv_rulePatternParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternParam"


    // $ANTLR start "rulePatternParam"
    // InternalSpectra.g:1190:1: rulePatternParam returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePatternParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSpectra.g:1196:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSpectra.g:1197:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSpectra.g:1197:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpectra.g:1198:3: (lv_name_0_0= RULE_ID )
            {
            // InternalSpectra.g:1198:3: (lv_name_0_0= RULE_ID )
            // InternalSpectra.g:1199:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPatternParamAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPatternParamRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternParam"


    // $ANTLR start "entryRuleTypedParamList"
    // InternalSpectra.g:1218:1: entryRuleTypedParamList returns [EObject current=null] : iv_ruleTypedParamList= ruleTypedParamList EOF ;
    public final EObject entryRuleTypedParamList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedParamList = null;


        try {
            // InternalSpectra.g:1218:55: (iv_ruleTypedParamList= ruleTypedParamList EOF )
            // InternalSpectra.g:1219:2: iv_ruleTypedParamList= ruleTypedParamList EOF
            {
             newCompositeNode(grammarAccess.getTypedParamListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedParamList=ruleTypedParamList();

            state._fsp--;

             current =iv_ruleTypedParamList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedParamList"


    // $ANTLR start "ruleTypedParamList"
    // InternalSpectra.g:1225:1: ruleTypedParamList returns [EObject current=null] : ( ( (lv_params_0_0= ruleTypedParam ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )* ) ;
    public final EObject ruleTypedParamList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1231:2: ( ( ( (lv_params_0_0= ruleTypedParam ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )* ) )
            // InternalSpectra.g:1232:2: ( ( (lv_params_0_0= ruleTypedParam ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )* )
            {
            // InternalSpectra.g:1232:2: ( ( (lv_params_0_0= ruleTypedParam ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )* )
            // InternalSpectra.g:1233:3: ( (lv_params_0_0= ruleTypedParam ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )*
            {
            // InternalSpectra.g:1233:3: ( (lv_params_0_0= ruleTypedParam ) )
            // InternalSpectra.g:1234:4: (lv_params_0_0= ruleTypedParam )
            {
            // InternalSpectra.g:1234:4: (lv_params_0_0= ruleTypedParam )
            // InternalSpectra.g:1235:5: lv_params_0_0= ruleTypedParam
            {

            					newCompositeNode(grammarAccess.getTypedParamListAccess().getParamsTypedParamParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_params_0_0=ruleTypedParam();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypedParamListRule());
            					}
            					add(
            						current,
            						"params",
            						lv_params_0_0,
            						"tau.smlab.syntech.Spectra.TypedParam");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:1252:3: (otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSpectra.g:1253:4: otherlv_1= ',' ( (lv_params_2_0= ruleTypedParam ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTypedParamListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalSpectra.g:1257:4: ( (lv_params_2_0= ruleTypedParam ) )
            	    // InternalSpectra.g:1258:5: (lv_params_2_0= ruleTypedParam )
            	    {
            	    // InternalSpectra.g:1258:5: (lv_params_2_0= ruleTypedParam )
            	    // InternalSpectra.g:1259:6: lv_params_2_0= ruleTypedParam
            	    {

            	    						newCompositeNode(grammarAccess.getTypedParamListAccess().getParamsTypedParamParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_params_2_0=ruleTypedParam();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTypedParamListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"params",
            	    							lv_params_2_0,
            	    							"tau.smlab.syntech.Spectra.TypedParam");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedParamList"


    // $ANTLR start "entryRuleTypedParam"
    // InternalSpectra.g:1281:1: entryRuleTypedParam returns [EObject current=null] : iv_ruleTypedParam= ruleTypedParam EOF ;
    public final EObject entryRuleTypedParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedParam = null;


        try {
            // InternalSpectra.g:1281:51: (iv_ruleTypedParam= ruleTypedParam EOF )
            // InternalSpectra.g:1282:2: iv_ruleTypedParam= ruleTypedParam EOF
            {
             newCompositeNode(grammarAccess.getTypedParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedParam=ruleTypedParam();

            state._fsp--;

             current =iv_ruleTypedParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedParam"


    // $ANTLR start "ruleTypedParam"
    // InternalSpectra.g:1288:1: ruleTypedParam returns [EObject current=null] : ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTypedParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1294:2: ( ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSpectra.g:1295:2: ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSpectra.g:1295:2: ( ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSpectra.g:1296:3: ( (lv_type_0_0= ruleVarType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSpectra.g:1296:3: ( (lv_type_0_0= ruleVarType ) )
            // InternalSpectra.g:1297:4: (lv_type_0_0= ruleVarType )
            {
            // InternalSpectra.g:1297:4: (lv_type_0_0= ruleVarType )
            // InternalSpectra.g:1298:5: lv_type_0_0= ruleVarType
            {

            					newCompositeNode(grammarAccess.getTypedParamAccess().getTypeVarTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleVarType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypedParamRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"tau.smlab.syntech.Spectra.VarType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:1315:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:1316:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:1316:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:1317:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypedParamAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypedParamRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedParam"


    // $ANTLR start "entryRuleCounter"
    // InternalSpectra.g:1337:1: entryRuleCounter returns [EObject current=null] : iv_ruleCounter= ruleCounter EOF ;
    public final EObject entryRuleCounter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounter = null;


        try {
            // InternalSpectra.g:1337:48: (iv_ruleCounter= ruleCounter EOF )
            // InternalSpectra.g:1338:2: iv_ruleCounter= ruleCounter EOF
            {
             newCompositeNode(grammarAccess.getCounterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCounter=ruleCounter();

            state._fsp--;

             current =iv_ruleCounter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCounter"


    // $ANTLR start "ruleCounter"
    // InternalSpectra.g:1344:1: ruleCounter returns [EObject current=null] : (otherlv_0= 'counter' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' ) otherlv_5= '{' ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )* otherlv_18= '}' ) ;
    public final EObject ruleCounter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        EObject lv_range_3_0 = null;

        EObject lv_initial_6_0 = null;

        EObject lv_resetPred_8_0 = null;

        EObject lv_incPred_10_0 = null;

        EObject lv_decPred_12_0 = null;

        Enumerator lv_overflowMethod_14_0 = null;

        Enumerator lv_underflowMethod_16_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1350:2: ( (otherlv_0= 'counter' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' ) otherlv_5= '{' ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )* otherlv_18= '}' ) )
            // InternalSpectra.g:1351:2: (otherlv_0= 'counter' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' ) otherlv_5= '{' ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )* otherlv_18= '}' )
            {
            // InternalSpectra.g:1351:2: (otherlv_0= 'counter' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' ) otherlv_5= '{' ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )* otherlv_18= '}' )
            // InternalSpectra.g:1352:3: otherlv_0= 'counter' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' ) otherlv_5= '{' ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCounterAccess().getCounterKeyword_0());
            		
            // InternalSpectra.g:1356:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:1357:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:1357:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:1358:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCounterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCounterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSpectra.g:1374:3: (otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')' )
            // InternalSpectra.g:1375:4: otherlv_2= '(' ( (lv_range_3_0= ruleSubrange ) ) otherlv_4= ')'
            {
            otherlv_2=(Token)match(input,28,FOLLOW_20); 

            				newLeafNode(otherlv_2, grammarAccess.getCounterAccess().getLeftParenthesisKeyword_2_0());
            			
            // InternalSpectra.g:1379:4: ( (lv_range_3_0= ruleSubrange ) )
            // InternalSpectra.g:1380:5: (lv_range_3_0= ruleSubrange )
            {
            // InternalSpectra.g:1380:5: (lv_range_3_0= ruleSubrange )
            // InternalSpectra.g:1381:6: lv_range_3_0= ruleSubrange
            {

            						newCompositeNode(grammarAccess.getCounterAccess().getRangeSubrangeParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_28);
            lv_range_3_0=ruleSubrange();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getCounterRule());
            						}
            						set(
            							current,
            							"range",
            							lv_range_3_0,
            							"tau.smlab.syntech.Spectra.Subrange");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_23); 

            				newLeafNode(otherlv_4, grammarAccess.getCounterAccess().getRightParenthesisKeyword_2_2());
            			

            }

            otherlv_5=(Token)match(input,23,FOLLOW_29); 

            			newLeafNode(otherlv_5, grammarAccess.getCounterAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSpectra.g:1407:3: ( ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==RULE_INT||LA18_0==16||LA18_0==26||LA18_0==28||(LA18_0>=30 && LA18_0<=34)||(LA18_0>=83 && LA18_0<=90)||(LA18_0>=98 && LA18_0<=101)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSpectra.g:1408:4: ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) ) ruleTOK_SEMI
            	    {
            	    // InternalSpectra.g:1408:4: ( ( (lv_initial_6_0= ruleTemporalInExpr ) ) | (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) ) | (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) ) | (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) ) | (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) ) | (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) ) )
            	    int alt17=6;
            	    switch ( input.LA(1) ) {
            	    case RULE_ID:
            	    case RULE_INT:
            	    case 16:
            	    case 26:
            	    case 28:
            	    case 83:
            	    case 84:
            	    case 85:
            	    case 86:
            	    case 87:
            	    case 88:
            	    case 89:
            	    case 90:
            	    case 98:
            	    case 99:
            	    case 100:
            	    case 101:
            	        {
            	        alt17=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt17=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt17=3;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt17=4;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt17=5;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt17=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt17) {
            	        case 1 :
            	            // InternalSpectra.g:1409:5: ( (lv_initial_6_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1409:5: ( (lv_initial_6_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1410:6: (lv_initial_6_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1410:6: (lv_initial_6_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1411:7: lv_initial_6_0= ruleTemporalInExpr
            	            {

            	            							newCompositeNode(grammarAccess.getCounterAccess().getInitialTemporalInExprParserRuleCall_4_0_0_0());
            	            						
            	            pushFollow(FOLLOW_13);
            	            lv_initial_6_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getCounterRule());
            	            							}
            	            							add(
            	            								current,
            	            								"initial",
            	            								lv_initial_6_0,
            	            								"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:1429:5: (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1429:5: (otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1430:6: otherlv_7= 'reset:' ( (lv_resetPred_8_0= ruleTemporalInExpr ) )
            	            {
            	            otherlv_7=(Token)match(input,30,FOLLOW_12); 

            	            						newLeafNode(otherlv_7, grammarAccess.getCounterAccess().getResetKeyword_4_0_1_0());
            	            					
            	            // InternalSpectra.g:1434:6: ( (lv_resetPred_8_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1435:7: (lv_resetPred_8_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1435:7: (lv_resetPred_8_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1436:8: lv_resetPred_8_0= ruleTemporalInExpr
            	            {

            	            								newCompositeNode(grammarAccess.getCounterAccess().getResetPredTemporalInExprParserRuleCall_4_0_1_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_resetPred_8_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCounterRule());
            	            								}
            	            								add(
            	            									current,
            	            									"resetPred",
            	            									lv_resetPred_8_0,
            	            									"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalSpectra.g:1455:5: (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) )
            	            {
            	            // InternalSpectra.g:1455:5: (otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) ) )
            	            // InternalSpectra.g:1456:6: otherlv_9= 'inc:' ( (lv_incPred_10_0= ruleTemporalExpression ) )
            	            {
            	            otherlv_9=(Token)match(input,31,FOLLOW_18); 

            	            						newLeafNode(otherlv_9, grammarAccess.getCounterAccess().getIncKeyword_4_0_2_0());
            	            					
            	            // InternalSpectra.g:1460:6: ( (lv_incPred_10_0= ruleTemporalExpression ) )
            	            // InternalSpectra.g:1461:7: (lv_incPred_10_0= ruleTemporalExpression )
            	            {
            	            // InternalSpectra.g:1461:7: (lv_incPred_10_0= ruleTemporalExpression )
            	            // InternalSpectra.g:1462:8: lv_incPred_10_0= ruleTemporalExpression
            	            {

            	            								newCompositeNode(grammarAccess.getCounterAccess().getIncPredTemporalExpressionParserRuleCall_4_0_2_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_incPred_10_0=ruleTemporalExpression();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCounterRule());
            	            								}
            	            								add(
            	            									current,
            	            									"incPred",
            	            									lv_incPred_10_0,
            	            									"tau.smlab.syntech.Spectra.TemporalExpression");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalSpectra.g:1481:5: (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) )
            	            {
            	            // InternalSpectra.g:1481:5: (otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) ) )
            	            // InternalSpectra.g:1482:6: otherlv_11= 'dec:' ( (lv_decPred_12_0= ruleTemporalExpression ) )
            	            {
            	            otherlv_11=(Token)match(input,32,FOLLOW_18); 

            	            						newLeafNode(otherlv_11, grammarAccess.getCounterAccess().getDecKeyword_4_0_3_0());
            	            					
            	            // InternalSpectra.g:1486:6: ( (lv_decPred_12_0= ruleTemporalExpression ) )
            	            // InternalSpectra.g:1487:7: (lv_decPred_12_0= ruleTemporalExpression )
            	            {
            	            // InternalSpectra.g:1487:7: (lv_decPred_12_0= ruleTemporalExpression )
            	            // InternalSpectra.g:1488:8: lv_decPred_12_0= ruleTemporalExpression
            	            {

            	            								newCompositeNode(grammarAccess.getCounterAccess().getDecPredTemporalExpressionParserRuleCall_4_0_3_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_decPred_12_0=ruleTemporalExpression();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCounterRule());
            	            								}
            	            								add(
            	            									current,
            	            									"decPred",
            	            									lv_decPred_12_0,
            	            									"tau.smlab.syntech.Spectra.TemporalExpression");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // InternalSpectra.g:1507:5: (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) )
            	            {
            	            // InternalSpectra.g:1507:5: (otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) ) )
            	            // InternalSpectra.g:1508:6: otherlv_13= 'overflow:' ( (lv_overflowMethod_14_0= ruleOverflowMethod ) )
            	            {
            	            otherlv_13=(Token)match(input,33,FOLLOW_30); 

            	            						newLeafNode(otherlv_13, grammarAccess.getCounterAccess().getOverflowKeyword_4_0_4_0());
            	            					
            	            // InternalSpectra.g:1512:6: ( (lv_overflowMethod_14_0= ruleOverflowMethod ) )
            	            // InternalSpectra.g:1513:7: (lv_overflowMethod_14_0= ruleOverflowMethod )
            	            {
            	            // InternalSpectra.g:1513:7: (lv_overflowMethod_14_0= ruleOverflowMethod )
            	            // InternalSpectra.g:1514:8: lv_overflowMethod_14_0= ruleOverflowMethod
            	            {

            	            								newCompositeNode(grammarAccess.getCounterAccess().getOverflowMethodOverflowMethodEnumRuleCall_4_0_4_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_overflowMethod_14_0=ruleOverflowMethod();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCounterRule());
            	            								}
            	            								add(
            	            									current,
            	            									"overflowMethod",
            	            									lv_overflowMethod_14_0,
            	            									"tau.smlab.syntech.Spectra.OverflowMethod");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // InternalSpectra.g:1533:5: (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) )
            	            {
            	            // InternalSpectra.g:1533:5: (otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) ) )
            	            // InternalSpectra.g:1534:6: otherlv_15= 'underflow:' ( (lv_underflowMethod_16_0= ruleOverflowMethod ) )
            	            {
            	            otherlv_15=(Token)match(input,34,FOLLOW_30); 

            	            						newLeafNode(otherlv_15, grammarAccess.getCounterAccess().getUnderflowKeyword_4_0_5_0());
            	            					
            	            // InternalSpectra.g:1538:6: ( (lv_underflowMethod_16_0= ruleOverflowMethod ) )
            	            // InternalSpectra.g:1539:7: (lv_underflowMethod_16_0= ruleOverflowMethod )
            	            {
            	            // InternalSpectra.g:1539:7: (lv_underflowMethod_16_0= ruleOverflowMethod )
            	            // InternalSpectra.g:1540:8: lv_underflowMethod_16_0= ruleOverflowMethod
            	            {

            	            								newCompositeNode(grammarAccess.getCounterAccess().getUnderflowMethodOverflowMethodEnumRuleCall_4_0_5_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_underflowMethod_16_0=ruleOverflowMethod();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCounterRule());
            	            								}
            	            								add(
            	            									current,
            	            									"underflowMethod",
            	            									lv_underflowMethod_16_0,
            	            									"tau.smlab.syntech.Spectra.OverflowMethod");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    				newCompositeNode(grammarAccess.getCounterAccess().getTOK_SEMIParserRuleCall_4_1());
            	    			
            	    pushFollow(FOLLOW_29);
            	    ruleTOK_SEMI();

            	    state._fsp--;


            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_18=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getCounterAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCounter"


    // $ANTLR start "entryRuleMonitor"
    // InternalSpectra.g:1575:1: entryRuleMonitor returns [EObject current=null] : iv_ruleMonitor= ruleMonitor EOF ;
    public final EObject entryRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonitor = null;


        try {
            // InternalSpectra.g:1575:48: (iv_ruleMonitor= ruleMonitor EOF )
            // InternalSpectra.g:1576:2: iv_ruleMonitor= ruleMonitor EOF
            {
             newCompositeNode(grammarAccess.getMonitorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMonitor=ruleMonitor();

            state._fsp--;

             current =iv_ruleMonitor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMonitor"


    // $ANTLR start "ruleMonitor"
    // InternalSpectra.g:1582:1: ruleMonitor returns [EObject current=null] : (otherlv_0= 'monitor' ( (lv_type_1_0= ruleVarType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )* otherlv_14= '}' ) ;
    public final EObject ruleMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        EObject lv_type_1_0 = null;

        EObject lv_initial_6_0 = null;

        EObject lv_safety_9_0 = null;

        EObject lv_stateInv_12_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1588:2: ( (otherlv_0= 'monitor' ( (lv_type_1_0= ruleVarType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )* otherlv_14= '}' ) )
            // InternalSpectra.g:1589:2: (otherlv_0= 'monitor' ( (lv_type_1_0= ruleVarType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )* otherlv_14= '}' )
            {
            // InternalSpectra.g:1589:2: (otherlv_0= 'monitor' ( (lv_type_1_0= ruleVarType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )* otherlv_14= '}' )
            // InternalSpectra.g:1590:3: otherlv_0= 'monitor' ( (lv_type_1_0= ruleVarType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getMonitorAccess().getMonitorKeyword_0());
            		
            // InternalSpectra.g:1594:3: ( (lv_type_1_0= ruleVarType ) )
            // InternalSpectra.g:1595:4: (lv_type_1_0= ruleVarType )
            {
            // InternalSpectra.g:1595:4: (lv_type_1_0= ruleVarType )
            // InternalSpectra.g:1596:5: lv_type_1_0= ruleVarType
            {

            					newCompositeNode(grammarAccess.getMonitorAccess().getTypeVarTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleVarType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMonitorRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"tau.smlab.syntech.Spectra.VarType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSpectra.g:1613:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSpectra.g:1614:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSpectra.g:1614:4: (lv_name_2_0= RULE_ID )
            // InternalSpectra.g:1615:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_2_0, grammarAccess.getMonitorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonitorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getMonitorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSpectra.g:1635:3: ( ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==RULE_INT||LA23_0==16||LA23_0==26||LA23_0==28||(LA23_0>=36 && LA23_0<=41)||(LA23_0>=83 && LA23_0<=90)||(LA23_0>=98 && LA23_0<=101)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSpectra.g:1636:4: ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI
            	    {
            	    // InternalSpectra.g:1636:4: ( ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) ) | ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) ) | ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) ) )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_ID:
            	    case RULE_INT:
            	    case 16:
            	    case 26:
            	    case 28:
            	    case 36:
            	    case 37:
            	    case 83:
            	    case 84:
            	    case 85:
            	    case 86:
            	    case 87:
            	    case 88:
            	    case 89:
            	    case 90:
            	    case 98:
            	    case 99:
            	    case 100:
            	    case 101:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 38:
            	    case 39:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 40:
            	    case 41:
            	        {
            	        alt22=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt22) {
            	        case 1 :
            	            // InternalSpectra.g:1637:5: ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1637:5: ( (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1638:6: (otherlv_4= 'ini' | otherlv_5= 'initially' )? ( (lv_initial_6_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1638:6: (otherlv_4= 'ini' | otherlv_5= 'initially' )?
            	            int alt19=3;
            	            int LA19_0 = input.LA(1);

            	            if ( (LA19_0==36) ) {
            	                alt19=1;
            	            }
            	            else if ( (LA19_0==37) ) {
            	                alt19=2;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // InternalSpectra.g:1639:7: otherlv_4= 'ini'
            	                    {
            	                    otherlv_4=(Token)match(input,36,FOLLOW_12); 

            	                    							newLeafNode(otherlv_4, grammarAccess.getMonitorAccess().getIniKeyword_4_0_0_0_0());
            	                    						

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1644:7: otherlv_5= 'initially'
            	                    {
            	                    otherlv_5=(Token)match(input,37,FOLLOW_12); 

            	                    							newLeafNode(otherlv_5, grammarAccess.getMonitorAccess().getInitiallyKeyword_4_0_0_0_1());
            	                    						

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1649:6: ( (lv_initial_6_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1650:7: (lv_initial_6_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1650:7: (lv_initial_6_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1651:8: lv_initial_6_0= ruleTemporalInExpr
            	            {

            	            								newCompositeNode(grammarAccess.getMonitorAccess().getInitialTemporalInExprParserRuleCall_4_0_0_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_initial_6_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getMonitorRule());
            	            								}
            	            								add(
            	            									current,
            	            									"initial",
            	            									lv_initial_6_0,
            	            									"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:1670:5: ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1670:5: ( (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1671:6: (otherlv_7= 'G' | otherlv_8= 'trans' ) ( (lv_safety_9_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1671:6: (otherlv_7= 'G' | otherlv_8= 'trans' )
            	            int alt20=2;
            	            int LA20_0 = input.LA(1);

            	            if ( (LA20_0==38) ) {
            	                alt20=1;
            	            }
            	            else if ( (LA20_0==39) ) {
            	                alt20=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 20, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt20) {
            	                case 1 :
            	                    // InternalSpectra.g:1672:7: otherlv_7= 'G'
            	                    {
            	                    otherlv_7=(Token)match(input,38,FOLLOW_12); 

            	                    							newLeafNode(otherlv_7, grammarAccess.getMonitorAccess().getGKeyword_4_0_1_0_0());
            	                    						

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1677:7: otherlv_8= 'trans'
            	                    {
            	                    otherlv_8=(Token)match(input,39,FOLLOW_12); 

            	                    							newLeafNode(otherlv_8, grammarAccess.getMonitorAccess().getTransKeyword_4_0_1_0_1());
            	                    						

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1682:6: ( (lv_safety_9_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1683:7: (lv_safety_9_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1683:7: (lv_safety_9_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1684:8: lv_safety_9_0= ruleTemporalInExpr
            	            {

            	            								newCompositeNode(grammarAccess.getMonitorAccess().getSafetyTemporalInExprParserRuleCall_4_0_1_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_safety_9_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getMonitorRule());
            	            								}
            	            								add(
            	            									current,
            	            									"safety",
            	            									lv_safety_9_0,
            	            									"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalSpectra.g:1703:5: ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1703:5: ( (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1704:6: (otherlv_10= 'always' | otherlv_11= 'alw' ) ( (lv_stateInv_12_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1704:6: (otherlv_10= 'always' | otherlv_11= 'alw' )
            	            int alt21=2;
            	            int LA21_0 = input.LA(1);

            	            if ( (LA21_0==40) ) {
            	                alt21=1;
            	            }
            	            else if ( (LA21_0==41) ) {
            	                alt21=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 21, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt21) {
            	                case 1 :
            	                    // InternalSpectra.g:1705:7: otherlv_10= 'always'
            	                    {
            	                    otherlv_10=(Token)match(input,40,FOLLOW_12); 

            	                    							newLeafNode(otherlv_10, grammarAccess.getMonitorAccess().getAlwaysKeyword_4_0_2_0_0());
            	                    						

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1710:7: otherlv_11= 'alw'
            	                    {
            	                    otherlv_11=(Token)match(input,41,FOLLOW_12); 

            	                    							newLeafNode(otherlv_11, grammarAccess.getMonitorAccess().getAlwKeyword_4_0_2_0_1());
            	                    						

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1715:6: ( (lv_stateInv_12_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1716:7: (lv_stateInv_12_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1716:7: (lv_stateInv_12_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1717:8: lv_stateInv_12_0= ruleTemporalInExpr
            	            {

            	            								newCompositeNode(grammarAccess.getMonitorAccess().getStateInvTemporalInExprParserRuleCall_4_0_2_1_0());
            	            							
            	            pushFollow(FOLLOW_13);
            	            lv_stateInv_12_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getMonitorRule());
            	            								}
            	            								add(
            	            									current,
            	            									"stateInv",
            	            									lv_stateInv_12_0,
            	            									"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    				newCompositeNode(grammarAccess.getMonitorAccess().getTOK_SEMIParserRuleCall_4_1());
            	    			
            	    pushFollow(FOLLOW_31);
            	    ruleTOK_SEMI();

            	    state._fsp--;


            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_14=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getMonitorAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMonitor"


    // $ANTLR start "entryRulePattern"
    // InternalSpectra.g:1752:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalSpectra.g:1752:48: (iv_rulePattern= rulePattern EOF )
            // InternalSpectra.g:1753:2: iv_rulePattern= rulePattern EOF
            {
             newCompositeNode(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;

             current =iv_rulePattern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalSpectra.g:1759:1: rulePattern returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )? (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' ) ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        EObject lv_params_3_0 = null;

        EObject lv_varDeclList_7_0 = null;

        EObject lv_initial_10_0 = null;

        EObject lv_safety_13_0 = null;

        EObject lv_stateInv_16_0 = null;

        EObject lv_justice_20_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:1765:2: ( (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )? (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' ) ) )
            // InternalSpectra.g:1766:2: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )? (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' ) )
            {
            // InternalSpectra.g:1766:2: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )? (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' ) )
            // InternalSpectra.g:1767:3: otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )? (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
            		
            // InternalSpectra.g:1771:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:1772:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:1772:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:1773:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSpectra.g:1789:3: (otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSpectra.g:1790:4: otherlv_2= '(' ( (lv_params_3_0= rulePatternParamList ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalSpectra.g:1794:4: ( (lv_params_3_0= rulePatternParamList ) )
                    // InternalSpectra.g:1795:5: (lv_params_3_0= rulePatternParamList )
                    {
                    // InternalSpectra.g:1795:5: (lv_params_3_0= rulePatternParamList )
                    // InternalSpectra.g:1796:6: lv_params_3_0= rulePatternParamList
                    {

                    						newCompositeNode(grammarAccess.getPatternAccess().getParamsPatternParamListParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_params_3_0=rulePatternParamList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPatternRule());
                    						}
                    						set(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"tau.smlab.syntech.Spectra.PatternParamList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:1818:3: (otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}' )
            // InternalSpectra.g:1819:4: otherlv_5= '{' (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )* ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+ otherlv_22= '}'
            {
            otherlv_5=(Token)match(input,23,FOLLOW_33); 

            				newLeafNode(otherlv_5, grammarAccess.getPatternAccess().getLeftCurlyBracketKeyword_3_0());
            			
            // InternalSpectra.g:1823:4: (otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==43) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSpectra.g:1824:5: otherlv_6= 'var' ( (lv_varDeclList_7_0= ruleVarDecl ) )
            	    {
            	    otherlv_6=(Token)match(input,43,FOLLOW_14); 

            	    					newLeafNode(otherlv_6, grammarAccess.getPatternAccess().getVarKeyword_3_1_0());
            	    				
            	    // InternalSpectra.g:1828:5: ( (lv_varDeclList_7_0= ruleVarDecl ) )
            	    // InternalSpectra.g:1829:6: (lv_varDeclList_7_0= ruleVarDecl )
            	    {
            	    // InternalSpectra.g:1829:6: (lv_varDeclList_7_0= ruleVarDecl )
            	    // InternalSpectra.g:1830:7: lv_varDeclList_7_0= ruleVarDecl
            	    {

            	    							newCompositeNode(grammarAccess.getPatternAccess().getVarDeclListVarDeclParserRuleCall_3_1_1_0());
            	    						
            	    pushFollow(FOLLOW_33);
            	    lv_varDeclList_7_0=ruleVarDecl();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getPatternRule());
            	    							}
            	    							add(
            	    								current,
            	    								"varDeclList",
            	    								lv_varDeclList_7_0,
            	    								"tau.smlab.syntech.Spectra.VarDecl");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // InternalSpectra.g:1848:4: ( ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||LA31_0==RULE_INT||LA31_0==16||LA31_0==26||LA31_0==28||(LA31_0>=36 && LA31_0<=41)||(LA31_0>=44 && LA31_0<=46)||(LA31_0>=83 && LA31_0<=90)||(LA31_0>=98 && LA31_0<=101)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSpectra.g:1849:5: ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) ) ruleTOK_SEMI
            	    {
            	    // InternalSpectra.g:1849:5: ( ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) ) | ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) ) | ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) ) | ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) ) )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_ID:
            	    case RULE_INT:
            	    case 16:
            	    case 26:
            	    case 28:
            	    case 36:
            	    case 37:
            	    case 83:
            	    case 84:
            	    case 85:
            	    case 86:
            	    case 87:
            	    case 88:
            	    case 89:
            	    case 90:
            	    case 98:
            	    case 99:
            	    case 100:
            	    case 101:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 38:
            	    case 39:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 40:
            	    case 41:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 44:
            	    case 45:
            	    case 46:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // InternalSpectra.g:1850:6: ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1850:6: ( (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1851:7: (otherlv_8= 'ini' | otherlv_9= 'initially' )? ( (lv_initial_10_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1851:7: (otherlv_8= 'ini' | otherlv_9= 'initially' )?
            	            int alt26=3;
            	            int LA26_0 = input.LA(1);

            	            if ( (LA26_0==36) ) {
            	                alt26=1;
            	            }
            	            else if ( (LA26_0==37) ) {
            	                alt26=2;
            	            }
            	            switch (alt26) {
            	                case 1 :
            	                    // InternalSpectra.g:1852:8: otherlv_8= 'ini'
            	                    {
            	                    otherlv_8=(Token)match(input,36,FOLLOW_12); 

            	                    								newLeafNode(otherlv_8, grammarAccess.getPatternAccess().getIniKeyword_3_2_0_0_0_0());
            	                    							

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1857:8: otherlv_9= 'initially'
            	                    {
            	                    otherlv_9=(Token)match(input,37,FOLLOW_12); 

            	                    								newLeafNode(otherlv_9, grammarAccess.getPatternAccess().getInitiallyKeyword_3_2_0_0_0_1());
            	                    							

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1862:7: ( (lv_initial_10_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1863:8: (lv_initial_10_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1863:8: (lv_initial_10_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1864:9: lv_initial_10_0= ruleTemporalInExpr
            	            {

            	            									newCompositeNode(grammarAccess.getPatternAccess().getInitialTemporalInExprParserRuleCall_3_2_0_0_1_0());
            	            								
            	            pushFollow(FOLLOW_13);
            	            lv_initial_10_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            									if (current==null) {
            	            										current = createModelElementForParent(grammarAccess.getPatternRule());
            	            									}
            	            									add(
            	            										current,
            	            										"initial",
            	            										lv_initial_10_0,
            	            										"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            									afterParserOrEnumRuleCall();
            	            								

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:1883:6: ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1883:6: ( (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1884:7: (otherlv_11= 'G' | otherlv_12= 'trans' ) ( (lv_safety_13_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1884:7: (otherlv_11= 'G' | otherlv_12= 'trans' )
            	            int alt27=2;
            	            int LA27_0 = input.LA(1);

            	            if ( (LA27_0==38) ) {
            	                alt27=1;
            	            }
            	            else if ( (LA27_0==39) ) {
            	                alt27=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 27, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt27) {
            	                case 1 :
            	                    // InternalSpectra.g:1885:8: otherlv_11= 'G'
            	                    {
            	                    otherlv_11=(Token)match(input,38,FOLLOW_12); 

            	                    								newLeafNode(otherlv_11, grammarAccess.getPatternAccess().getGKeyword_3_2_0_1_0_0());
            	                    							

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1890:8: otherlv_12= 'trans'
            	                    {
            	                    otherlv_12=(Token)match(input,39,FOLLOW_12); 

            	                    								newLeafNode(otherlv_12, grammarAccess.getPatternAccess().getTransKeyword_3_2_0_1_0_1());
            	                    							

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1895:7: ( (lv_safety_13_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1896:8: (lv_safety_13_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1896:8: (lv_safety_13_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1897:9: lv_safety_13_0= ruleTemporalInExpr
            	            {

            	            									newCompositeNode(grammarAccess.getPatternAccess().getSafetyTemporalInExprParserRuleCall_3_2_0_1_1_0());
            	            								
            	            pushFollow(FOLLOW_13);
            	            lv_safety_13_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            									if (current==null) {
            	            										current = createModelElementForParent(grammarAccess.getPatternRule());
            	            									}
            	            									add(
            	            										current,
            	            										"safety",
            	            										lv_safety_13_0,
            	            										"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            									afterParserOrEnumRuleCall();
            	            								

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalSpectra.g:1916:6: ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1916:6: ( (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1917:7: (otherlv_14= 'always' | otherlv_15= 'alw' ) ( (lv_stateInv_16_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1917:7: (otherlv_14= 'always' | otherlv_15= 'alw' )
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( (LA28_0==40) ) {
            	                alt28=1;
            	            }
            	            else if ( (LA28_0==41) ) {
            	                alt28=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 28, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // InternalSpectra.g:1918:8: otherlv_14= 'always'
            	                    {
            	                    otherlv_14=(Token)match(input,40,FOLLOW_12); 

            	                    								newLeafNode(otherlv_14, grammarAccess.getPatternAccess().getAlwaysKeyword_3_2_0_2_0_0());
            	                    							

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1923:8: otherlv_15= 'alw'
            	                    {
            	                    otherlv_15=(Token)match(input,41,FOLLOW_12); 

            	                    								newLeafNode(otherlv_15, grammarAccess.getPatternAccess().getAlwKeyword_3_2_0_2_0_1());
            	                    							

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1928:7: ( (lv_stateInv_16_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1929:8: (lv_stateInv_16_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1929:8: (lv_stateInv_16_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1930:9: lv_stateInv_16_0= ruleTemporalInExpr
            	            {

            	            									newCompositeNode(grammarAccess.getPatternAccess().getStateInvTemporalInExprParserRuleCall_3_2_0_2_1_0());
            	            								
            	            pushFollow(FOLLOW_13);
            	            lv_stateInv_16_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            									if (current==null) {
            	            										current = createModelElementForParent(grammarAccess.getPatternRule());
            	            									}
            	            									add(
            	            										current,
            	            										"stateInv",
            	            										lv_stateInv_16_0,
            	            										"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            									afterParserOrEnumRuleCall();
            	            								

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalSpectra.g:1949:6: ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) )
            	            {
            	            // InternalSpectra.g:1949:6: ( (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) ) )
            	            // InternalSpectra.g:1950:7: (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' ) ( (lv_justice_20_0= ruleTemporalInExpr ) )
            	            {
            	            // InternalSpectra.g:1950:7: (otherlv_17= 'GF' | otherlv_18= 'alwEv' | otherlv_19= 'alwaysEventually' )
            	            int alt29=3;
            	            switch ( input.LA(1) ) {
            	            case 44:
            	                {
            	                alt29=1;
            	                }
            	                break;
            	            case 45:
            	                {
            	                alt29=2;
            	                }
            	                break;
            	            case 46:
            	                {
            	                alt29=3;
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 29, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt29) {
            	                case 1 :
            	                    // InternalSpectra.g:1951:8: otherlv_17= 'GF'
            	                    {
            	                    otherlv_17=(Token)match(input,44,FOLLOW_12); 

            	                    								newLeafNode(otherlv_17, grammarAccess.getPatternAccess().getGFKeyword_3_2_0_3_0_0());
            	                    							

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:1956:8: otherlv_18= 'alwEv'
            	                    {
            	                    otherlv_18=(Token)match(input,45,FOLLOW_12); 

            	                    								newLeafNode(otherlv_18, grammarAccess.getPatternAccess().getAlwEvKeyword_3_2_0_3_0_1());
            	                    							

            	                    }
            	                    break;
            	                case 3 :
            	                    // InternalSpectra.g:1961:8: otherlv_19= 'alwaysEventually'
            	                    {
            	                    otherlv_19=(Token)match(input,46,FOLLOW_12); 

            	                    								newLeafNode(otherlv_19, grammarAccess.getPatternAccess().getAlwaysEventuallyKeyword_3_2_0_3_0_2());
            	                    							

            	                    }
            	                    break;

            	            }

            	            // InternalSpectra.g:1966:7: ( (lv_justice_20_0= ruleTemporalInExpr ) )
            	            // InternalSpectra.g:1967:8: (lv_justice_20_0= ruleTemporalInExpr )
            	            {
            	            // InternalSpectra.g:1967:8: (lv_justice_20_0= ruleTemporalInExpr )
            	            // InternalSpectra.g:1968:9: lv_justice_20_0= ruleTemporalInExpr
            	            {

            	            									newCompositeNode(grammarAccess.getPatternAccess().getJusticeTemporalInExprParserRuleCall_3_2_0_3_1_0());
            	            								
            	            pushFollow(FOLLOW_13);
            	            lv_justice_20_0=ruleTemporalInExpr();

            	            state._fsp--;


            	            									if (current==null) {
            	            										current = createModelElementForParent(grammarAccess.getPatternRule());
            	            									}
            	            									add(
            	            										current,
            	            										"justice",
            	            										lv_justice_20_0,
            	            										"tau.smlab.syntech.Spectra.TemporalInExpr");
            	            									afterParserOrEnumRuleCall();
            	            								

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    					newCompositeNode(grammarAccess.getPatternAccess().getTOK_SEMIParserRuleCall_3_2_1());
            	    				
            	    pushFollow(FOLLOW_34);
            	    ruleTOK_SEMI();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            otherlv_22=(Token)match(input,25,FOLLOW_2); 

            				newLeafNode(otherlv_22, grammarAccess.getPatternAccess().getRightCurlyBracketKeyword_3_3());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRulePredicate"
    // InternalSpectra.g:2004:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalSpectra.g:2004:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalSpectra.g:2005:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalSpectra.g:2011:1: rulePredicate returns [EObject current=null] : (otherlv_0= 'predicate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' ) ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) ) ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_params_3_0 = null;

        EObject lv_body_7_0 = null;

        EObject lv_body_10_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2017:2: ( (otherlv_0= 'predicate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' ) ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) ) ) )
            // InternalSpectra.g:2018:2: (otherlv_0= 'predicate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' ) ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) ) )
            {
            // InternalSpectra.g:2018:2: (otherlv_0= 'predicate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' ) ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) ) )
            // InternalSpectra.g:2019:3: otherlv_0= 'predicate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' ) ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPredicateAccess().getPredicateKeyword_0());
            		
            // InternalSpectra.g:2023:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpectra.g:2024:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSpectra.g:2024:4: (lv_name_1_0= RULE_ID )
            // InternalSpectra.g:2025:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPredicateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSpectra.g:2041:3: ( (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' ) | otherlv_5= '()' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==28) ) {
                alt32=1;
            }
            else if ( (LA32_0==48) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalSpectra.g:2042:4: (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' )
                    {
                    // InternalSpectra.g:2042:4: (otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')' )
                    // InternalSpectra.g:2043:5: otherlv_2= '(' ( (lv_params_3_0= ruleTypedParamList ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_14); 

                    					newLeafNode(otherlv_2, grammarAccess.getPredicateAccess().getLeftParenthesisKeyword_2_0_0());
                    				
                    // InternalSpectra.g:2047:5: ( (lv_params_3_0= ruleTypedParamList ) )
                    // InternalSpectra.g:2048:6: (lv_params_3_0= ruleTypedParamList )
                    {
                    // InternalSpectra.g:2048:6: (lv_params_3_0= ruleTypedParamList )
                    // InternalSpectra.g:2049:7: lv_params_3_0= ruleTypedParamList
                    {

                    							newCompositeNode(grammarAccess.getPredicateAccess().getParamsTypedParamListParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_28);
                    lv_params_3_0=ruleTypedParamList();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPredicateRule());
                    							}
                    							set(
                    								current,
                    								"params",
                    								lv_params_3_0,
                    								"tau.smlab.syntech.Spectra.TypedParamList");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_36); 

                    					newLeafNode(otherlv_4, grammarAccess.getPredicateAccess().getRightParenthesisKeyword_2_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2072:4: otherlv_5= '()'
                    {
                    otherlv_5=(Token)match(input,48,FOLLOW_36); 

                    				newLeafNode(otherlv_5, grammarAccess.getPredicateAccess().getLeftParenthesisRightParenthesisKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2077:3: ( (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI ) | (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==15) ) {
                alt33=1;
            }
            else if ( (LA33_0==23) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalSpectra.g:2078:4: (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI )
                    {
                    // InternalSpectra.g:2078:4: (otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI )
                    // InternalSpectra.g:2079:5: otherlv_6= ':' ( (lv_body_7_0= ruleTemporalExpression ) ) ruleTOK_SEMI
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_18); 

                    					newLeafNode(otherlv_6, grammarAccess.getPredicateAccess().getColonKeyword_3_0_0());
                    				
                    // InternalSpectra.g:2083:5: ( (lv_body_7_0= ruleTemporalExpression ) )
                    // InternalSpectra.g:2084:6: (lv_body_7_0= ruleTemporalExpression )
                    {
                    // InternalSpectra.g:2084:6: (lv_body_7_0= ruleTemporalExpression )
                    // InternalSpectra.g:2085:7: lv_body_7_0= ruleTemporalExpression
                    {

                    							newCompositeNode(grammarAccess.getPredicateAccess().getBodyTemporalExpressionParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_body_7_0=ruleTemporalExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPredicateRule());
                    							}
                    							set(
                    								current,
                    								"body",
                    								lv_body_7_0,
                    								"tau.smlab.syntech.Spectra.TemporalExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    					newCompositeNode(grammarAccess.getPredicateAccess().getTOK_SEMIParserRuleCall_3_0_2());
                    				
                    pushFollow(FOLLOW_2);
                    ruleTOK_SEMI();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2111:4: (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' )
                    {
                    // InternalSpectra.g:2111:4: (otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}' )
                    // InternalSpectra.g:2112:5: otherlv_9= '{' ( (lv_body_10_0= ruleTemporalExpression ) ) otherlv_11= '}'
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_18); 

                    					newLeafNode(otherlv_9, grammarAccess.getPredicateAccess().getLeftCurlyBracketKeyword_3_1_0());
                    				
                    // InternalSpectra.g:2116:5: ( (lv_body_10_0= ruleTemporalExpression ) )
                    // InternalSpectra.g:2117:6: (lv_body_10_0= ruleTemporalExpression )
                    {
                    // InternalSpectra.g:2117:6: (lv_body_10_0= ruleTemporalExpression )
                    // InternalSpectra.g:2118:7: lv_body_10_0= ruleTemporalExpression
                    {

                    							newCompositeNode(grammarAccess.getPredicateAccess().getBodyTemporalExpressionParserRuleCall_3_1_1_0());
                    						
                    pushFollow(FOLLOW_37);
                    lv_body_10_0=ruleTemporalExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPredicateRule());
                    							}
                    							set(
                    								current,
                    								"body",
                    								lv_body_10_0,
                    								"tau.smlab.syntech.Spectra.TemporalExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_11=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(otherlv_11, grammarAccess.getPredicateAccess().getRightCurlyBracketKeyword_3_1_2());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleVarType"
    // InternalSpectra.g:2145:1: entryRuleVarType returns [EObject current=null] : iv_ruleVarType= ruleVarType EOF ;
    public final EObject entryRuleVarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarType = null;


        try {
            // InternalSpectra.g:2145:48: (iv_ruleVarType= ruleVarType EOF )
            // InternalSpectra.g:2146:2: iv_ruleVarType= ruleVarType EOF
            {
             newCompositeNode(grammarAccess.getVarTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarType=ruleVarType();

            state._fsp--;

             current =iv_ruleVarType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarType"


    // $ANTLR start "ruleVarType"
    // InternalSpectra.g:2152:1: ruleVarType returns [EObject current=null] : ( ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) ) (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )* ) ;
    public final EObject ruleVarType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_subr_3_0 = null;

        EObject lv_const_6_0 = null;

        EObject lv_const_8_0 = null;

        EObject lv_dimensions_12_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2158:2: ( ( ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) ) (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )* ) )
            // InternalSpectra.g:2159:2: ( ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) ) (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )* )
            {
            // InternalSpectra.g:2159:2: ( ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) ) (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )* )
            // InternalSpectra.g:2160:3: ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) ) (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )*
            {
            // InternalSpectra.g:2160:3: ( ( (lv_name_0_0= 'boolean' ) ) | (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' ) | (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' ) | ( (otherlv_10= RULE_ID ) ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt35=1;
                }
                break;
            case 50:
                {
                alt35=2;
                }
                break;
            case 23:
                {
                alt35=3;
                }
                break;
            case RULE_ID:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSpectra.g:2161:4: ( (lv_name_0_0= 'boolean' ) )
                    {
                    // InternalSpectra.g:2161:4: ( (lv_name_0_0= 'boolean' ) )
                    // InternalSpectra.g:2162:5: (lv_name_0_0= 'boolean' )
                    {
                    // InternalSpectra.g:2162:5: (lv_name_0_0= 'boolean' )
                    // InternalSpectra.g:2163:6: lv_name_0_0= 'boolean'
                    {
                    lv_name_0_0=(Token)match(input,49,FOLLOW_38); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getVarTypeAccess().getNameBooleanKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVarTypeRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_0, "boolean");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2176:4: (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' )
                    {
                    // InternalSpectra.g:2176:4: (otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')' )
                    // InternalSpectra.g:2177:5: otherlv_1= 'Int' otherlv_2= '(' ( (lv_subr_3_0= ruleSubrange ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_27); 

                    					newLeafNode(otherlv_1, grammarAccess.getVarTypeAccess().getIntKeyword_0_1_0());
                    				
                    otherlv_2=(Token)match(input,28,FOLLOW_20); 

                    					newLeafNode(otherlv_2, grammarAccess.getVarTypeAccess().getLeftParenthesisKeyword_0_1_1());
                    				
                    // InternalSpectra.g:2185:5: ( (lv_subr_3_0= ruleSubrange ) )
                    // InternalSpectra.g:2186:6: (lv_subr_3_0= ruleSubrange )
                    {
                    // InternalSpectra.g:2186:6: (lv_subr_3_0= ruleSubrange )
                    // InternalSpectra.g:2187:7: lv_subr_3_0= ruleSubrange
                    {

                    							newCompositeNode(grammarAccess.getVarTypeAccess().getSubrSubrangeParserRuleCall_0_1_2_0());
                    						
                    pushFollow(FOLLOW_28);
                    lv_subr_3_0=ruleSubrange();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getVarTypeRule());
                    							}
                    							set(
                    								current,
                    								"subr",
                    								lv_subr_3_0,
                    								"tau.smlab.syntech.Spectra.Subrange");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_38); 

                    					newLeafNode(otherlv_4, grammarAccess.getVarTypeAccess().getRightParenthesisKeyword_0_1_3());
                    				

                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:2210:4: (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' )
                    {
                    // InternalSpectra.g:2210:4: (otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}' )
                    // InternalSpectra.g:2211:5: otherlv_5= '{' ( (lv_const_6_0= ruleTypeConstant ) ) (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )* otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_39); 

                    					newLeafNode(otherlv_5, grammarAccess.getVarTypeAccess().getLeftCurlyBracketKeyword_0_2_0());
                    				
                    // InternalSpectra.g:2215:5: ( (lv_const_6_0= ruleTypeConstant ) )
                    // InternalSpectra.g:2216:6: (lv_const_6_0= ruleTypeConstant )
                    {
                    // InternalSpectra.g:2216:6: (lv_const_6_0= ruleTypeConstant )
                    // InternalSpectra.g:2217:7: lv_const_6_0= ruleTypeConstant
                    {

                    							newCompositeNode(grammarAccess.getVarTypeAccess().getConstTypeConstantParserRuleCall_0_2_1_0());
                    						
                    pushFollow(FOLLOW_24);
                    lv_const_6_0=ruleTypeConstant();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getVarTypeRule());
                    							}
                    							add(
                    								current,
                    								"const",
                    								lv_const_6_0,
                    								"tau.smlab.syntech.Spectra.TypeConstant");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalSpectra.g:2234:5: (otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==24) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalSpectra.g:2235:6: otherlv_7= ',' ( (lv_const_8_0= ruleTypeConstant ) )
                    	    {
                    	    otherlv_7=(Token)match(input,24,FOLLOW_39); 

                    	    						newLeafNode(otherlv_7, grammarAccess.getVarTypeAccess().getCommaKeyword_0_2_2_0());
                    	    					
                    	    // InternalSpectra.g:2239:6: ( (lv_const_8_0= ruleTypeConstant ) )
                    	    // InternalSpectra.g:2240:7: (lv_const_8_0= ruleTypeConstant )
                    	    {
                    	    // InternalSpectra.g:2240:7: (lv_const_8_0= ruleTypeConstant )
                    	    // InternalSpectra.g:2241:8: lv_const_8_0= ruleTypeConstant
                    	    {

                    	    								newCompositeNode(grammarAccess.getVarTypeAccess().getConstTypeConstantParserRuleCall_0_2_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_24);
                    	    lv_const_8_0=ruleTypeConstant();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getVarTypeRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"const",
                    	    									lv_const_8_0,
                    	    									"tau.smlab.syntech.Spectra.TypeConstant");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,25,FOLLOW_38); 

                    					newLeafNode(otherlv_9, grammarAccess.getVarTypeAccess().getRightCurlyBracketKeyword_0_2_3());
                    				

                    }


                    }
                    break;
                case 4 :
                    // InternalSpectra.g:2265:4: ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalSpectra.g:2265:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSpectra.g:2266:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSpectra.g:2266:5: (otherlv_10= RULE_ID )
                    // InternalSpectra.g:2267:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVarTypeRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_38); 

                    						newLeafNode(otherlv_10, grammarAccess.getVarTypeAccess().getTypeTypeDefCrossReference_0_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSpectra.g:2279:3: (otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==21) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSpectra.g:2280:4: otherlv_11= '[' ( (lv_dimensions_12_0= ruleSizeDefineDecl ) ) otherlv_13= ']'
            	    {
            	    otherlv_11=(Token)match(input,21,FOLLOW_20); 

            	    				newLeafNode(otherlv_11, grammarAccess.getVarTypeAccess().getLeftSquareBracketKeyword_1_0());
            	    			
            	    // InternalSpectra.g:2284:4: ( (lv_dimensions_12_0= ruleSizeDefineDecl ) )
            	    // InternalSpectra.g:2285:5: (lv_dimensions_12_0= ruleSizeDefineDecl )
            	    {
            	    // InternalSpectra.g:2285:5: (lv_dimensions_12_0= ruleSizeDefineDecl )
            	    // InternalSpectra.g:2286:6: lv_dimensions_12_0= ruleSizeDefineDecl
            	    {

            	    						newCompositeNode(grammarAccess.getVarTypeAccess().getDimensionsSizeDefineDeclParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_dimensions_12_0=ruleSizeDefineDecl();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getVarTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dimensions",
            	    							lv_dimensions_12_0,
            	    							"tau.smlab.syntech.Spectra.SizeDefineDecl");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_13=(Token)match(input,22,FOLLOW_38); 

            	    				newLeafNode(otherlv_13, grammarAccess.getVarTypeAccess().getRightSquareBracketKeyword_1_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarType"


    // $ANTLR start "entryRuleLTLGar"
    // InternalSpectra.g:2312:1: entryRuleLTLGar returns [EObject current=null] : iv_ruleLTLGar= ruleLTLGar EOF ;
    public final EObject entryRuleLTLGar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLTLGar = null;


        try {
            // InternalSpectra.g:2312:47: (iv_ruleLTLGar= ruleLTLGar EOF )
            // InternalSpectra.g:2313:2: iv_ruleLTLGar= ruleLTLGar EOF
            {
             newCompositeNode(grammarAccess.getLTLGarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLTLGar=ruleLTLGar();

            state._fsp--;

             current =iv_ruleLTLGar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLTLGar"


    // $ANTLR start "ruleLTLGar"
    // InternalSpectra.g:2319:1: ruleLTLGar returns [EObject current=null] : ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI ) ;
    public final EObject ruleLTLGar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_safety_9_1=null;
        Token lv_safety_9_2=null;
        Token lv_stateInv_10_1=null;
        Token lv_stateInv_10_2=null;
        Token lv_justice_11_1=null;
        Token lv_justice_11_2=null;
        Token lv_justice_11_3=null;
        EObject lv_params_4_0 = null;

        EObject lv_temporalExpr_12_0 = null;

        EObject lv_trig_13_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2325:2: ( ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:2326:2: ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:2326:2: ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI )
            // InternalSpectra.g:2327:3: (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:2327:3: (otherlv_0= 'guarantee' | otherlv_1= 'gar' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==51) ) {
                alt37=1;
            }
            else if ( (LA37_0==52) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalSpectra.g:2328:4: otherlv_0= 'guarantee'
                    {
                    otherlv_0=(Token)match(input,51,FOLLOW_40); 

                    				newLeafNode(otherlv_0, grammarAccess.getLTLGarAccess().getGuaranteeKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2333:4: otherlv_1= 'gar'
                    {
                    otherlv_1=(Token)match(input,52,FOLLOW_40); 

                    				newLeafNode(otherlv_1, grammarAccess.getLTLGarAccess().getGarKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2338:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==15||LA39_1==23) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalSpectra.g:2339:4: ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':'
                    {
                    // InternalSpectra.g:2339:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalSpectra.g:2340:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalSpectra.g:2340:5: (lv_name_2_0= RULE_ID )
                    // InternalSpectra.g:2341:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getLTLGarAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLTLGarRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSpectra.g:2357:4: (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==23) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalSpectra.g:2358:5: otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}'
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_14); 

                            					newLeafNode(otherlv_3, grammarAccess.getLTLGarAccess().getLeftCurlyBracketKeyword_1_1_0());
                            				
                            // InternalSpectra.g:2362:5: ( (lv_params_4_0= ruleTypedParamList ) )
                            // InternalSpectra.g:2363:6: (lv_params_4_0= ruleTypedParamList )
                            {
                            // InternalSpectra.g:2363:6: (lv_params_4_0= ruleTypedParamList )
                            // InternalSpectra.g:2364:7: lv_params_4_0= ruleTypedParamList
                            {

                            							newCompositeNode(grammarAccess.getLTLGarAccess().getParamsTypedParamListParserRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_37);
                            lv_params_4_0=ruleTypedParamList();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLTLGarRule());
                            							}
                            							set(
                            								current,
                            								"params",
                            								lv_params_4_0,
                            								"tau.smlab.syntech.Spectra.TypedParamList");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_5=(Token)match(input,25,FOLLOW_9); 

                            					newLeafNode(otherlv_5, grammarAccess.getLTLGarAccess().getRightCurlyBracketKeyword_1_1_2());
                            				

                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,15,FOLLOW_40); 

                    				newLeafNode(otherlv_6, grammarAccess.getLTLGarAccess().getColonKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2391:3: ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID||LA44_0==RULE_INT||LA44_0==16||LA44_0==26||LA44_0==28||(LA44_0>=36 && LA44_0<=41)||(LA44_0>=44 && LA44_0<=46)||(LA44_0>=83 && LA44_0<=90)||(LA44_0>=98 && LA44_0<=101)||(LA44_0>=106 && LA44_0<=107)) ) {
                alt44=1;
            }
            else if ( (LA44_0==102) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalSpectra.g:2392:4: ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) )
                    {
                    // InternalSpectra.g:2392:4: ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) )
                    // InternalSpectra.g:2393:5: (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) )
                    {
                    // InternalSpectra.g:2393:5: (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )?
                    int alt43=6;
                    switch ( input.LA(1) ) {
                        case 36:
                            {
                            alt43=1;
                            }
                            break;
                        case 37:
                            {
                            alt43=2;
                            }
                            break;
                        case 38:
                        case 39:
                            {
                            alt43=3;
                            }
                            break;
                        case 40:
                        case 41:
                            {
                            alt43=4;
                            }
                            break;
                        case 44:
                        case 45:
                        case 46:
                            {
                            alt43=5;
                            }
                            break;
                    }

                    switch (alt43) {
                        case 1 :
                            // InternalSpectra.g:2394:6: otherlv_7= 'ini'
                            {
                            otherlv_7=(Token)match(input,36,FOLLOW_18); 

                            						newLeafNode(otherlv_7, grammarAccess.getLTLGarAccess().getIniKeyword_2_0_0_0());
                            					

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:2399:6: otherlv_8= 'initially'
                            {
                            otherlv_8=(Token)match(input,37,FOLLOW_18); 

                            						newLeafNode(otherlv_8, grammarAccess.getLTLGarAccess().getInitiallyKeyword_2_0_0_1());
                            					

                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:2404:6: ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) )
                            {
                            // InternalSpectra.g:2404:6: ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) )
                            // InternalSpectra.g:2405:7: ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) )
                            {
                            // InternalSpectra.g:2405:7: ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) )
                            // InternalSpectra.g:2406:8: (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' )
                            {
                            // InternalSpectra.g:2406:8: (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==38) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==39) ) {
                                alt40=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 40, 0, input);

                                throw nvae;
                            }
                            switch (alt40) {
                                case 1 :
                                    // InternalSpectra.g:2407:9: lv_safety_9_1= 'G'
                                    {
                                    lv_safety_9_1=(Token)match(input,38,FOLLOW_18); 

                                    									newLeafNode(lv_safety_9_1, grammarAccess.getLTLGarAccess().getSafetyGKeyword_2_0_0_2_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "safety", lv_safety_9_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2418:9: lv_safety_9_2= 'trans'
                                    {
                                    lv_safety_9_2=(Token)match(input,39,FOLLOW_18); 

                                    									newLeafNode(lv_safety_9_2, grammarAccess.getLTLGarAccess().getSafetyTransKeyword_2_0_0_2_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "safety", lv_safety_9_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:2432:6: ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) )
                            {
                            // InternalSpectra.g:2432:6: ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) )
                            // InternalSpectra.g:2433:7: ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) )
                            {
                            // InternalSpectra.g:2433:7: ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) )
                            // InternalSpectra.g:2434:8: (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' )
                            {
                            // InternalSpectra.g:2434:8: (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' )
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==40) ) {
                                alt41=1;
                            }
                            else if ( (LA41_0==41) ) {
                                alt41=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 41, 0, input);

                                throw nvae;
                            }
                            switch (alt41) {
                                case 1 :
                                    // InternalSpectra.g:2435:9: lv_stateInv_10_1= 'always'
                                    {
                                    lv_stateInv_10_1=(Token)match(input,40,FOLLOW_18); 

                                    									newLeafNode(lv_stateInv_10_1, grammarAccess.getLTLGarAccess().getStateInvAlwaysKeyword_2_0_0_3_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "stateInv", lv_stateInv_10_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2446:9: lv_stateInv_10_2= 'alw'
                                    {
                                    lv_stateInv_10_2=(Token)match(input,41,FOLLOW_18); 

                                    									newLeafNode(lv_stateInv_10_2, grammarAccess.getLTLGarAccess().getStateInvAlwKeyword_2_0_0_3_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "stateInv", lv_stateInv_10_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // InternalSpectra.g:2460:6: ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) )
                            {
                            // InternalSpectra.g:2460:6: ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) )
                            // InternalSpectra.g:2461:7: ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) )
                            {
                            // InternalSpectra.g:2461:7: ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) )
                            // InternalSpectra.g:2462:8: (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' )
                            {
                            // InternalSpectra.g:2462:8: (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' )
                            int alt42=3;
                            switch ( input.LA(1) ) {
                            case 44:
                                {
                                alt42=1;
                                }
                                break;
                            case 45:
                                {
                                alt42=2;
                                }
                                break;
                            case 46:
                                {
                                alt42=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 42, 0, input);

                                throw nvae;
                            }

                            switch (alt42) {
                                case 1 :
                                    // InternalSpectra.g:2463:9: lv_justice_11_1= 'GF'
                                    {
                                    lv_justice_11_1=(Token)match(input,44,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_1, grammarAccess.getLTLGarAccess().getJusticeGFKeyword_2_0_0_4_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2474:9: lv_justice_11_2= 'alwEv'
                                    {
                                    lv_justice_11_2=(Token)match(input,45,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_2, grammarAccess.getLTLGarAccess().getJusticeAlwEvKeyword_2_0_0_4_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_2, null);
                                    								

                                    }
                                    break;
                                case 3 :
                                    // InternalSpectra.g:2485:9: lv_justice_11_3= 'alwaysEventually'
                                    {
                                    lv_justice_11_3=(Token)match(input,46,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_3, grammarAccess.getLTLGarAccess().getJusticeAlwaysEventuallyKeyword_2_0_0_4_0_2());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLGarRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_3, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }

                    // InternalSpectra.g:2499:5: ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) )
                    // InternalSpectra.g:2500:6: (lv_temporalExpr_12_0= ruleQuantifierExpr )
                    {
                    // InternalSpectra.g:2500:6: (lv_temporalExpr_12_0= ruleQuantifierExpr )
                    // InternalSpectra.g:2501:7: lv_temporalExpr_12_0= ruleQuantifierExpr
                    {

                    							newCompositeNode(grammarAccess.getLTLGarAccess().getTemporalExprQuantifierExprParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_temporalExpr_12_0=ruleQuantifierExpr();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getLTLGarRule());
                    							}
                    							set(
                    								current,
                    								"temporalExpr",
                    								lv_temporalExpr_12_0,
                    								"tau.smlab.syntech.Spectra.QuantifierExpr");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2520:4: ( (lv_trig_13_0= ruleTrigger ) )
                    {
                    // InternalSpectra.g:2520:4: ( (lv_trig_13_0= ruleTrigger ) )
                    // InternalSpectra.g:2521:5: (lv_trig_13_0= ruleTrigger )
                    {
                    // InternalSpectra.g:2521:5: (lv_trig_13_0= ruleTrigger )
                    // InternalSpectra.g:2522:6: lv_trig_13_0= ruleTrigger
                    {

                    						newCompositeNode(grammarAccess.getLTLGarAccess().getTrigTriggerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_trig_13_0=ruleTrigger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLTLGarRule());
                    						}
                    						set(
                    							current,
                    							"trig",
                    							lv_trig_13_0,
                    							"tau.smlab.syntech.Spectra.Trigger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getLTLGarAccess().getTOK_SEMIParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLTLGar"


    // $ANTLR start "entryRuleLTLAsm"
    // InternalSpectra.g:2551:1: entryRuleLTLAsm returns [EObject current=null] : iv_ruleLTLAsm= ruleLTLAsm EOF ;
    public final EObject entryRuleLTLAsm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLTLAsm = null;


        try {
            // InternalSpectra.g:2551:47: (iv_ruleLTLAsm= ruleLTLAsm EOF )
            // InternalSpectra.g:2552:2: iv_ruleLTLAsm= ruleLTLAsm EOF
            {
             newCompositeNode(grammarAccess.getLTLAsmRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLTLAsm=ruleLTLAsm();

            state._fsp--;

             current =iv_ruleLTLAsm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLTLAsm"


    // $ANTLR start "ruleLTLAsm"
    // InternalSpectra.g:2558:1: ruleLTLAsm returns [EObject current=null] : ( (otherlv_0= 'assumption' | otherlv_1= 'asm' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI ) ;
    public final EObject ruleLTLAsm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_safety_9_1=null;
        Token lv_safety_9_2=null;
        Token lv_stateInv_10_1=null;
        Token lv_stateInv_10_2=null;
        Token lv_justice_11_1=null;
        Token lv_justice_11_2=null;
        Token lv_justice_11_3=null;
        EObject lv_params_4_0 = null;

        EObject lv_temporalExpr_12_0 = null;

        EObject lv_trig_13_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2564:2: ( ( (otherlv_0= 'assumption' | otherlv_1= 'asm' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:2565:2: ( (otherlv_0= 'assumption' | otherlv_1= 'asm' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:2565:2: ( (otherlv_0= 'assumption' | otherlv_1= 'asm' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI )
            // InternalSpectra.g:2566:3: (otherlv_0= 'assumption' | otherlv_1= 'asm' ) ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )? ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:2566:3: (otherlv_0= 'assumption' | otherlv_1= 'asm' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            else if ( (LA45_0==54) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalSpectra.g:2567:4: otherlv_0= 'assumption'
                    {
                    otherlv_0=(Token)match(input,53,FOLLOW_40); 

                    				newLeafNode(otherlv_0, grammarAccess.getLTLAsmAccess().getAssumptionKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2572:4: otherlv_1= 'asm'
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_40); 

                    				newLeafNode(otherlv_1, grammarAccess.getLTLAsmAccess().getAsmKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2577:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==15||LA47_1==23) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalSpectra.g:2578:4: ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )? otherlv_6= ':'
                    {
                    // InternalSpectra.g:2578:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalSpectra.g:2579:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalSpectra.g:2579:5: (lv_name_2_0= RULE_ID )
                    // InternalSpectra.g:2580:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getLTLAsmAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLTLAsmRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSpectra.g:2596:4: (otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}' )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==23) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalSpectra.g:2597:5: otherlv_3= '{' ( (lv_params_4_0= ruleTypedParamList ) ) otherlv_5= '}'
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_14); 

                            					newLeafNode(otherlv_3, grammarAccess.getLTLAsmAccess().getLeftCurlyBracketKeyword_1_1_0());
                            				
                            // InternalSpectra.g:2601:5: ( (lv_params_4_0= ruleTypedParamList ) )
                            // InternalSpectra.g:2602:6: (lv_params_4_0= ruleTypedParamList )
                            {
                            // InternalSpectra.g:2602:6: (lv_params_4_0= ruleTypedParamList )
                            // InternalSpectra.g:2603:7: lv_params_4_0= ruleTypedParamList
                            {

                            							newCompositeNode(grammarAccess.getLTLAsmAccess().getParamsTypedParamListParserRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_37);
                            lv_params_4_0=ruleTypedParamList();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLTLAsmRule());
                            							}
                            							set(
                            								current,
                            								"params",
                            								lv_params_4_0,
                            								"tau.smlab.syntech.Spectra.TypedParamList");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_5=(Token)match(input,25,FOLLOW_9); 

                            					newLeafNode(otherlv_5, grammarAccess.getLTLAsmAccess().getRightCurlyBracketKeyword_1_1_2());
                            				

                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,15,FOLLOW_40); 

                    				newLeafNode(otherlv_6, grammarAccess.getLTLAsmAccess().getColonKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2630:3: ( ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) ) | ( (lv_trig_13_0= ruleTrigger ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID||LA52_0==RULE_INT||LA52_0==16||LA52_0==26||LA52_0==28||(LA52_0>=36 && LA52_0<=41)||(LA52_0>=44 && LA52_0<=46)||(LA52_0>=83 && LA52_0<=90)||(LA52_0>=98 && LA52_0<=101)||(LA52_0>=106 && LA52_0<=107)) ) {
                alt52=1;
            }
            else if ( (LA52_0==102) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalSpectra.g:2631:4: ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) )
                    {
                    // InternalSpectra.g:2631:4: ( (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) ) )
                    // InternalSpectra.g:2632:5: (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )? ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) )
                    {
                    // InternalSpectra.g:2632:5: (otherlv_7= 'ini' | otherlv_8= 'initially' | ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) ) | ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) ) | ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) ) )?
                    int alt51=6;
                    switch ( input.LA(1) ) {
                        case 36:
                            {
                            alt51=1;
                            }
                            break;
                        case 37:
                            {
                            alt51=2;
                            }
                            break;
                        case 38:
                        case 39:
                            {
                            alt51=3;
                            }
                            break;
                        case 40:
                        case 41:
                            {
                            alt51=4;
                            }
                            break;
                        case 44:
                        case 45:
                        case 46:
                            {
                            alt51=5;
                            }
                            break;
                    }

                    switch (alt51) {
                        case 1 :
                            // InternalSpectra.g:2633:6: otherlv_7= 'ini'
                            {
                            otherlv_7=(Token)match(input,36,FOLLOW_18); 

                            						newLeafNode(otherlv_7, grammarAccess.getLTLAsmAccess().getIniKeyword_2_0_0_0());
                            					

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:2638:6: otherlv_8= 'initially'
                            {
                            otherlv_8=(Token)match(input,37,FOLLOW_18); 

                            						newLeafNode(otherlv_8, grammarAccess.getLTLAsmAccess().getInitiallyKeyword_2_0_0_1());
                            					

                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:2643:6: ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) )
                            {
                            // InternalSpectra.g:2643:6: ( ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) ) )
                            // InternalSpectra.g:2644:7: ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) )
                            {
                            // InternalSpectra.g:2644:7: ( (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' ) )
                            // InternalSpectra.g:2645:8: (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' )
                            {
                            // InternalSpectra.g:2645:8: (lv_safety_9_1= 'G' | lv_safety_9_2= 'trans' )
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==38) ) {
                                alt48=1;
                            }
                            else if ( (LA48_0==39) ) {
                                alt48=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 48, 0, input);

                                throw nvae;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalSpectra.g:2646:9: lv_safety_9_1= 'G'
                                    {
                                    lv_safety_9_1=(Token)match(input,38,FOLLOW_18); 

                                    									newLeafNode(lv_safety_9_1, grammarAccess.getLTLAsmAccess().getSafetyGKeyword_2_0_0_2_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "safety", lv_safety_9_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2657:9: lv_safety_9_2= 'trans'
                                    {
                                    lv_safety_9_2=(Token)match(input,39,FOLLOW_18); 

                                    									newLeafNode(lv_safety_9_2, grammarAccess.getLTLAsmAccess().getSafetyTransKeyword_2_0_0_2_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "safety", lv_safety_9_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:2671:6: ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) )
                            {
                            // InternalSpectra.g:2671:6: ( ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) ) )
                            // InternalSpectra.g:2672:7: ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) )
                            {
                            // InternalSpectra.g:2672:7: ( (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' ) )
                            // InternalSpectra.g:2673:8: (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' )
                            {
                            // InternalSpectra.g:2673:8: (lv_stateInv_10_1= 'always' | lv_stateInv_10_2= 'alw' )
                            int alt49=2;
                            int LA49_0 = input.LA(1);

                            if ( (LA49_0==40) ) {
                                alt49=1;
                            }
                            else if ( (LA49_0==41) ) {
                                alt49=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 49, 0, input);

                                throw nvae;
                            }
                            switch (alt49) {
                                case 1 :
                                    // InternalSpectra.g:2674:9: lv_stateInv_10_1= 'always'
                                    {
                                    lv_stateInv_10_1=(Token)match(input,40,FOLLOW_18); 

                                    									newLeafNode(lv_stateInv_10_1, grammarAccess.getLTLAsmAccess().getStateInvAlwaysKeyword_2_0_0_3_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "stateInv", lv_stateInv_10_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2685:9: lv_stateInv_10_2= 'alw'
                                    {
                                    lv_stateInv_10_2=(Token)match(input,41,FOLLOW_18); 

                                    									newLeafNode(lv_stateInv_10_2, grammarAccess.getLTLAsmAccess().getStateInvAlwKeyword_2_0_0_3_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "stateInv", lv_stateInv_10_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // InternalSpectra.g:2699:6: ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) )
                            {
                            // InternalSpectra.g:2699:6: ( ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) ) )
                            // InternalSpectra.g:2700:7: ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) )
                            {
                            // InternalSpectra.g:2700:7: ( (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' ) )
                            // InternalSpectra.g:2701:8: (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' )
                            {
                            // InternalSpectra.g:2701:8: (lv_justice_11_1= 'GF' | lv_justice_11_2= 'alwEv' | lv_justice_11_3= 'alwaysEventually' )
                            int alt50=3;
                            switch ( input.LA(1) ) {
                            case 44:
                                {
                                alt50=1;
                                }
                                break;
                            case 45:
                                {
                                alt50=2;
                                }
                                break;
                            case 46:
                                {
                                alt50=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 50, 0, input);

                                throw nvae;
                            }

                            switch (alt50) {
                                case 1 :
                                    // InternalSpectra.g:2702:9: lv_justice_11_1= 'GF'
                                    {
                                    lv_justice_11_1=(Token)match(input,44,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_1, grammarAccess.getLTLAsmAccess().getJusticeGFKeyword_2_0_0_4_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:2713:9: lv_justice_11_2= 'alwEv'
                                    {
                                    lv_justice_11_2=(Token)match(input,45,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_2, grammarAccess.getLTLAsmAccess().getJusticeAlwEvKeyword_2_0_0_4_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_2, null);
                                    								

                                    }
                                    break;
                                case 3 :
                                    // InternalSpectra.g:2724:9: lv_justice_11_3= 'alwaysEventually'
                                    {
                                    lv_justice_11_3=(Token)match(input,46,FOLLOW_18); 

                                    									newLeafNode(lv_justice_11_3, grammarAccess.getLTLAsmAccess().getJusticeAlwaysEventuallyKeyword_2_0_0_4_0_2());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getLTLAsmRule());
                                    									}
                                    									setWithLastConsumed(current, "justice", lv_justice_11_3, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }

                    // InternalSpectra.g:2738:5: ( (lv_temporalExpr_12_0= ruleQuantifierExpr ) )
                    // InternalSpectra.g:2739:6: (lv_temporalExpr_12_0= ruleQuantifierExpr )
                    {
                    // InternalSpectra.g:2739:6: (lv_temporalExpr_12_0= ruleQuantifierExpr )
                    // InternalSpectra.g:2740:7: lv_temporalExpr_12_0= ruleQuantifierExpr
                    {

                    							newCompositeNode(grammarAccess.getLTLAsmAccess().getTemporalExprQuantifierExprParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_temporalExpr_12_0=ruleQuantifierExpr();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getLTLAsmRule());
                    							}
                    							set(
                    								current,
                    								"temporalExpr",
                    								lv_temporalExpr_12_0,
                    								"tau.smlab.syntech.Spectra.QuantifierExpr");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2759:4: ( (lv_trig_13_0= ruleTrigger ) )
                    {
                    // InternalSpectra.g:2759:4: ( (lv_trig_13_0= ruleTrigger ) )
                    // InternalSpectra.g:2760:5: (lv_trig_13_0= ruleTrigger )
                    {
                    // InternalSpectra.g:2760:5: (lv_trig_13_0= ruleTrigger )
                    // InternalSpectra.g:2761:6: lv_trig_13_0= ruleTrigger
                    {

                    						newCompositeNode(grammarAccess.getLTLAsmAccess().getTrigTriggerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_trig_13_0=ruleTrigger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLTLAsmRule());
                    						}
                    						set(
                    							current,
                    							"trig",
                    							lv_trig_13_0,
                    							"tau.smlab.syntech.Spectra.Trigger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getLTLAsmAccess().getTOK_SEMIParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLTLAsm"


    // $ANTLR start "entryRuleEXGar"
    // InternalSpectra.g:2790:1: entryRuleEXGar returns [EObject current=null] : iv_ruleEXGar= ruleEXGar EOF ;
    public final EObject entryRuleEXGar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEXGar = null;


        try {
            // InternalSpectra.g:2790:46: (iv_ruleEXGar= ruleEXGar EOF )
            // InternalSpectra.g:2791:2: iv_ruleEXGar= ruleEXGar EOF
            {
             newCompositeNode(grammarAccess.getEXGarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEXGar=ruleEXGar();

            state._fsp--;

             current =iv_ruleEXGar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEXGar"


    // $ANTLR start "ruleEXGar"
    // InternalSpectra.g:2797:1: ruleEXGar returns [EObject current=null] : ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) ) ruleTOK_SEMI ) ;
    public final EObject ruleEXGar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_elements_5_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_regExp_11_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2803:2: ( ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:2804:2: ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:2804:2: ( (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) ) ruleTOK_SEMI )
            // InternalSpectra.g:2805:3: (otherlv_0= 'guarantee' | otherlv_1= 'gar' ) ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) ) ruleTOK_SEMI
            {
            // InternalSpectra.g:2805:3: (otherlv_0= 'guarantee' | otherlv_1= 'gar' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==51) ) {
                alt53=1;
            }
            else if ( (LA53_0==52) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalSpectra.g:2806:4: otherlv_0= 'guarantee'
                    {
                    otherlv_0=(Token)match(input,51,FOLLOW_41); 

                    				newLeafNode(otherlv_0, grammarAccess.getEXGarAccess().getGuaranteeKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2811:4: otherlv_1= 'gar'
                    {
                    otherlv_1=(Token)match(input,52,FOLLOW_41); 

                    				newLeafNode(otherlv_1, grammarAccess.getEXGarAccess().getGarKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2816:3: ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalSpectra.g:2817:4: ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':'
                    {
                    // InternalSpectra.g:2817:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalSpectra.g:2818:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalSpectra.g:2818:5: (lv_name_2_0= RULE_ID )
                    // InternalSpectra.g:2819:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getEXGarAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEXGarRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,15,FOLLOW_42); 

                    				newLeafNode(otherlv_3, grammarAccess.getEXGarAccess().getColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2840:3: ( (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* ) | (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) ) | (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) ) )
            int alt56=3;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==55) ) {
                alt56=1;
            }
            else if ( (LA56_0==56) ) {
                int LA56_2 = input.LA(2);

                if ( (LA56_2==21||LA56_2==28||LA56_2==48||(LA56_2>=98 && LA56_2<=101)||LA56_2==105) ) {
                    alt56=3;
                }
                else if ( (LA56_2==RULE_ID) ) {
                    alt56=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalSpectra.g:2841:4: (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* )
                    {
                    // InternalSpectra.g:2841:4: (otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )* )
                    // InternalSpectra.g:2842:5: otherlv_4= 'GE' ( (lv_elements_5_0= ruleTemporalInExpr ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )*
                    {
                    otherlv_4=(Token)match(input,55,FOLLOW_12); 

                    					newLeafNode(otherlv_4, grammarAccess.getEXGarAccess().getGEKeyword_2_0_0());
                    				
                    // InternalSpectra.g:2846:5: ( (lv_elements_5_0= ruleTemporalInExpr ) )
                    // InternalSpectra.g:2847:6: (lv_elements_5_0= ruleTemporalInExpr )
                    {
                    // InternalSpectra.g:2847:6: (lv_elements_5_0= ruleTemporalInExpr )
                    // InternalSpectra.g:2848:7: lv_elements_5_0= ruleTemporalInExpr
                    {

                    							newCompositeNode(grammarAccess.getEXGarAccess().getElementsTemporalInExprParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_43);
                    lv_elements_5_0=ruleTemporalInExpr();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEXGarRule());
                    							}
                    							add(
                    								current,
                    								"elements",
                    								lv_elements_5_0,
                    								"tau.smlab.syntech.Spectra.TemporalInExpr");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalSpectra.g:2865:5: (otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==24) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalSpectra.g:2866:6: otherlv_6= ',' ( (lv_elements_7_0= ruleTemporalInExpr ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_12); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getEXGarAccess().getCommaKeyword_2_0_2_0());
                    	    					
                    	    // InternalSpectra.g:2870:6: ( (lv_elements_7_0= ruleTemporalInExpr ) )
                    	    // InternalSpectra.g:2871:7: (lv_elements_7_0= ruleTemporalInExpr )
                    	    {
                    	    // InternalSpectra.g:2871:7: (lv_elements_7_0= ruleTemporalInExpr )
                    	    // InternalSpectra.g:2872:8: lv_elements_7_0= ruleTemporalInExpr
                    	    {

                    	    								newCompositeNode(grammarAccess.getEXGarAccess().getElementsTemporalInExprParserRuleCall_2_0_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_43);
                    	    lv_elements_7_0=ruleTemporalInExpr();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getEXGarRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"elements",
                    	    									lv_elements_7_0,
                    	    									"tau.smlab.syntech.Spectra.TemporalInExpr");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:2892:4: (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // InternalSpectra.g:2892:4: (otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) ) )
                    // InternalSpectra.g:2893:5: otherlv_8= 'GEF' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,56,FOLLOW_4); 

                    					newLeafNode(otherlv_8, grammarAccess.getEXGarAccess().getGEFKeyword_2_1_0());
                    				
                    // InternalSpectra.g:2897:5: ( (otherlv_9= RULE_ID ) )
                    // InternalSpectra.g:2898:6: (otherlv_9= RULE_ID )
                    {
                    // InternalSpectra.g:2898:6: (otherlv_9= RULE_ID )
                    // InternalSpectra.g:2899:7: otherlv_9= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEXGarRule());
                    							}
                    						
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_13); 

                    							newLeafNode(otherlv_9, grammarAccess.getEXGarAccess().getRegExpPointerDefineRegExpDeclCrossReference_2_1_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:2912:4: (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) )
                    {
                    // InternalSpectra.g:2912:4: (otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) ) )
                    // InternalSpectra.g:2913:5: otherlv_10= 'GEF' ( (lv_regExp_11_0= ruleRegExp ) )
                    {
                    otherlv_10=(Token)match(input,56,FOLLOW_25); 

                    					newLeafNode(otherlv_10, grammarAccess.getEXGarAccess().getGEFKeyword_2_2_0());
                    				
                    // InternalSpectra.g:2917:5: ( (lv_regExp_11_0= ruleRegExp ) )
                    // InternalSpectra.g:2918:6: (lv_regExp_11_0= ruleRegExp )
                    {
                    // InternalSpectra.g:2918:6: (lv_regExp_11_0= ruleRegExp )
                    // InternalSpectra.g:2919:7: lv_regExp_11_0= ruleRegExp
                    {

                    							newCompositeNode(grammarAccess.getEXGarAccess().getRegExpRegExpParserRuleCall_2_2_1_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_regExp_11_0=ruleRegExp();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEXGarRule());
                    							}
                    							set(
                    								current,
                    								"regExp",
                    								lv_regExp_11_0,
                    								"tau.smlab.syntech.Spectra.RegExp");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getEXGarAccess().getTOK_SEMIParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEXGar"


    // $ANTLR start "entryRuleRegexpTest"
    // InternalSpectra.g:2949:1: entryRuleRegexpTest returns [EObject current=null] : iv_ruleRegexpTest= ruleRegexpTest EOF ;
    public final EObject entryRuleRegexpTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexpTest = null;


        try {
            // InternalSpectra.g:2949:51: (iv_ruleRegexpTest= ruleRegexpTest EOF )
            // InternalSpectra.g:2950:2: iv_ruleRegexpTest= ruleRegexpTest EOF
            {
             newCompositeNode(grammarAccess.getRegexpTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegexpTest=ruleRegexpTest();

            state._fsp--;

             current =iv_ruleRegexpTest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegexpTest"


    // $ANTLR start "ruleRegexpTest"
    // InternalSpectra.g:2956:1: ruleRegexpTest returns [EObject current=null] : (otherlv_0= 'regtest' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) ) ruleTOK_SEMI ) ;
    public final EObject ruleRegexpTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_regExp_4_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:2962:2: ( (otherlv_0= 'regtest' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) ) ruleTOK_SEMI ) )
            // InternalSpectra.g:2963:2: (otherlv_0= 'regtest' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) ) ruleTOK_SEMI )
            {
            // InternalSpectra.g:2963:2: (otherlv_0= 'regtest' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) ) ruleTOK_SEMI )
            // InternalSpectra.g:2964:3: otherlv_0= 'regtest' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )? ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) ) ruleTOK_SEMI
            {
            otherlv_0=(Token)match(input,57,FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexpTestAccess().getRegtestKeyword_0());
            		
            // InternalSpectra.g:2968:3: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==15) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalSpectra.g:2969:4: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':'
                    {
                    // InternalSpectra.g:2969:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpectra.g:2970:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpectra.g:2970:5: (lv_name_1_0= RULE_ID )
                    // InternalSpectra.g:2971:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getRegexpTestAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegexpTestRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,15,FOLLOW_44); 

                    				newLeafNode(otherlv_2, grammarAccess.getRegexpTestAccess().getColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalSpectra.g:2992:3: ( ( (otherlv_3= RULE_ID ) ) | ( (lv_regExp_4_0= ruleRegExp ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            else if ( (LA58_0==21||LA58_0==28||LA58_0==48||(LA58_0>=98 && LA58_0<=101)||LA58_0==105) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalSpectra.g:2993:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalSpectra.g:2993:4: ( (otherlv_3= RULE_ID ) )
                    // InternalSpectra.g:2994:5: (otherlv_3= RULE_ID )
                    {
                    // InternalSpectra.g:2994:5: (otherlv_3= RULE_ID )
                    // InternalSpectra.g:2995:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegexpTestRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_3, grammarAccess.getRegexpTestAccess().getRegExpPointerDefineRegExpDeclCrossReference_2_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:3007:4: ( (lv_regExp_4_0= ruleRegExp ) )
                    {
                    // InternalSpectra.g:3007:4: ( (lv_regExp_4_0= ruleRegExp ) )
                    // InternalSpectra.g:3008:5: (lv_regExp_4_0= ruleRegExp )
                    {
                    // InternalSpectra.g:3008:5: (lv_regExp_4_0= ruleRegExp )
                    // InternalSpectra.g:3009:6: lv_regExp_4_0= ruleRegExp
                    {

                    						newCompositeNode(grammarAccess.getRegexpTestAccess().getRegExpRegExpParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_regExp_4_0=ruleRegExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegexpTestRule());
                    						}
                    						set(
                    							current,
                    							"regExp",
                    							lv_regExp_4_0,
                    							"tau.smlab.syntech.Spectra.RegExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getRegexpTestAccess().getTOK_SEMIParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            ruleTOK_SEMI();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegexpTest"


    // $ANTLR start "entryRuleTemporalExpression"
    // InternalSpectra.g:3038:1: entryRuleTemporalExpression returns [EObject current=null] : iv_ruleTemporalExpression= ruleTemporalExpression EOF ;
    public final EObject entryRuleTemporalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalExpression = null;


        try {
            // InternalSpectra.g:3038:59: (iv_ruleTemporalExpression= ruleTemporalExpression EOF )
            // InternalSpectra.g:3039:2: iv_ruleTemporalExpression= ruleTemporalExpression EOF
            {
             newCompositeNode(grammarAccess.getTemporalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalExpression=ruleTemporalExpression();

            state._fsp--;

             current =iv_ruleTemporalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalExpression"


    // $ANTLR start "ruleTemporalExpression"
    // InternalSpectra.g:3045:1: ruleTemporalExpression returns [EObject current=null] : this_QuantifierExpr_0= ruleQuantifierExpr ;
    public final EObject ruleTemporalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_QuantifierExpr_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3051:2: (this_QuantifierExpr_0= ruleQuantifierExpr )
            // InternalSpectra.g:3052:2: this_QuantifierExpr_0= ruleQuantifierExpr
            {

            		newCompositeNode(grammarAccess.getTemporalExpressionAccess().getQuantifierExprParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_QuantifierExpr_0=ruleQuantifierExpr();

            state._fsp--;


            		current = this_QuantifierExpr_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalExpression"


    // $ANTLR start "entryRuleTemporalInExpr"
    // InternalSpectra.g:3063:1: entryRuleTemporalInExpr returns [EObject current=null] : iv_ruleTemporalInExpr= ruleTemporalInExpr EOF ;
    public final EObject entryRuleTemporalInExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalInExpr = null;


        try {
            // InternalSpectra.g:3063:55: (iv_ruleTemporalInExpr= ruleTemporalInExpr EOF )
            // InternalSpectra.g:3064:2: iv_ruleTemporalInExpr= ruleTemporalInExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalInExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalInExpr=ruleTemporalInExpr();

            state._fsp--;

             current =iv_ruleTemporalInExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalInExpr"


    // $ANTLR start "ruleTemporalInExpr"
    // InternalSpectra.g:3070:1: ruleTemporalInExpr returns [EObject current=null] : (this_TemporalImpExpr_0= ruleTemporalImpExpr ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )? ) ;
    public final EObject ruleTemporalInExpr() throws RecognitionException {
        EObject current = null;

        Token lv_not_2_0=null;
        Token lv_operator_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_TemporalImpExpr_0 = null;

        EObject lv_values_5_0 = null;

        EObject lv_values_7_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3076:2: ( (this_TemporalImpExpr_0= ruleTemporalImpExpr ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )? ) )
            // InternalSpectra.g:3077:2: (this_TemporalImpExpr_0= ruleTemporalImpExpr ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )? )
            {
            // InternalSpectra.g:3077:2: (this_TemporalImpExpr_0= ruleTemporalImpExpr ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )? )
            // InternalSpectra.g:3078:3: this_TemporalImpExpr_0= ruleTemporalImpExpr ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )?
            {

            			newCompositeNode(grammarAccess.getTemporalInExprAccess().getTemporalImpExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_45);
            this_TemporalImpExpr_0=ruleTemporalImpExpr();

            state._fsp--;


            			current = this_TemporalImpExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3086:3: ( () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=58 && LA61_0<=59)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalSpectra.g:3087:4: () ( (lv_not_2_0= 'not' ) )? ( (lv_operator_3_0= 'in' ) ) otherlv_4= '{' ( (lv_values_5_0= ruleValueInRange ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )* otherlv_8= '}'
                    {
                    // InternalSpectra.g:3087:4: ()
                    // InternalSpectra.g:3088:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getTemporalInExprAccess().getTemporalInExprLeftAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:3094:4: ( (lv_not_2_0= 'not' ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==58) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalSpectra.g:3095:5: (lv_not_2_0= 'not' )
                            {
                            // InternalSpectra.g:3095:5: (lv_not_2_0= 'not' )
                            // InternalSpectra.g:3096:6: lv_not_2_0= 'not'
                            {
                            lv_not_2_0=(Token)match(input,58,FOLLOW_46); 

                            						newLeafNode(lv_not_2_0, grammarAccess.getTemporalInExprAccess().getNotNotKeyword_1_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTemporalInExprRule());
                            						}
                            						setWithLastConsumed(current, "not", lv_not_2_0 != null, "not");
                            					

                            }


                            }
                            break;

                    }

                    // InternalSpectra.g:3108:4: ( (lv_operator_3_0= 'in' ) )
                    // InternalSpectra.g:3109:5: (lv_operator_3_0= 'in' )
                    {
                    // InternalSpectra.g:3109:5: (lv_operator_3_0= 'in' )
                    // InternalSpectra.g:3110:6: lv_operator_3_0= 'in'
                    {
                    lv_operator_3_0=(Token)match(input,59,FOLLOW_23); 

                    						newLeafNode(lv_operator_3_0, grammarAccess.getTemporalInExprAccess().getOperatorInKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTemporalInExprRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_0, "in");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_47); 

                    				newLeafNode(otherlv_4, grammarAccess.getTemporalInExprAccess().getLeftCurlyBracketKeyword_1_3());
                    			
                    // InternalSpectra.g:3126:4: ( (lv_values_5_0= ruleValueInRange ) )
                    // InternalSpectra.g:3127:5: (lv_values_5_0= ruleValueInRange )
                    {
                    // InternalSpectra.g:3127:5: (lv_values_5_0= ruleValueInRange )
                    // InternalSpectra.g:3128:6: lv_values_5_0= ruleValueInRange
                    {

                    						newCompositeNode(grammarAccess.getTemporalInExprAccess().getValuesValueInRangeParserRuleCall_1_4_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_values_5_0=ruleValueInRange();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemporalInExprRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_5_0,
                    							"tau.smlab.syntech.Spectra.ValueInRange");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSpectra.g:3145:4: (otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==24) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalSpectra.g:3146:5: otherlv_6= ',' ( (lv_values_7_0= ruleValueInRange ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_47); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTemporalInExprAccess().getCommaKeyword_1_5_0());
                    	    				
                    	    // InternalSpectra.g:3150:5: ( (lv_values_7_0= ruleValueInRange ) )
                    	    // InternalSpectra.g:3151:6: (lv_values_7_0= ruleValueInRange )
                    	    {
                    	    // InternalSpectra.g:3151:6: (lv_values_7_0= ruleValueInRange )
                    	    // InternalSpectra.g:3152:7: lv_values_7_0= ruleValueInRange
                    	    {

                    	    							newCompositeNode(grammarAccess.getTemporalInExprAccess().getValuesValueInRangeParserRuleCall_1_5_1_0());
                    	    						
                    	    pushFollow(FOLLOW_24);
                    	    lv_values_7_0=ruleValueInRange();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTemporalInExprRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_7_0,
                    	    								"tau.smlab.syntech.Spectra.ValueInRange");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getTemporalInExprAccess().getRightCurlyBracketKeyword_1_6());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalInExpr"


    // $ANTLR start "entryRuleTemporalImpExpr"
    // InternalSpectra.g:3179:1: entryRuleTemporalImpExpr returns [EObject current=null] : iv_ruleTemporalImpExpr= ruleTemporalImpExpr EOF ;
    public final EObject entryRuleTemporalImpExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalImpExpr = null;


        try {
            // InternalSpectra.g:3179:56: (iv_ruleTemporalImpExpr= ruleTemporalImpExpr EOF )
            // InternalSpectra.g:3180:2: iv_ruleTemporalImpExpr= ruleTemporalImpExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalImpExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalImpExpr=ruleTemporalImpExpr();

            state._fsp--;

             current =iv_ruleTemporalImpExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalImpExpr"


    // $ANTLR start "ruleTemporalImpExpr"
    // InternalSpectra.g:3186:1: ruleTemporalImpExpr returns [EObject current=null] : (this_TemporalIffExpr_0= ruleTemporalIffExpr ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )? ) ;
    public final EObject ruleTemporalImpExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalIffExpr_0 = null;

        EObject lv_implication_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3192:2: ( (this_TemporalIffExpr_0= ruleTemporalIffExpr ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )? ) )
            // InternalSpectra.g:3193:2: (this_TemporalIffExpr_0= ruleTemporalIffExpr ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )? )
            {
            // InternalSpectra.g:3193:2: (this_TemporalIffExpr_0= ruleTemporalIffExpr ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )? )
            // InternalSpectra.g:3194:3: this_TemporalIffExpr_0= ruleTemporalIffExpr ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )?
            {

            			newCompositeNode(grammarAccess.getTemporalImpExprAccess().getTemporalIffExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_48);
            this_TemporalIffExpr_0=ruleTemporalIffExpr();

            state._fsp--;


            			current = this_TemporalIffExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3202:3: ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=60 && LA63_0<=61)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalSpectra.g:3203:4: () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) ) ( (lv_implication_3_0= ruleTemporalImpExpr ) )
                    {
                    // InternalSpectra.g:3203:4: ()
                    // InternalSpectra.g:3204:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getTemporalImpExprAccess().getTemporalImpExprLeftAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:3210:4: ( ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) ) )
                    // InternalSpectra.g:3211:5: ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) )
                    {
                    // InternalSpectra.g:3211:5: ( (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' ) )
                    // InternalSpectra.g:3212:6: (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' )
                    {
                    // InternalSpectra.g:3212:6: (lv_operator_2_1= '->' | lv_operator_2_2= 'implies' )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==60) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==61) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalSpectra.g:3213:7: lv_operator_2_1= '->'
                            {
                            lv_operator_2_1=(Token)match(input,60,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalImpExprAccess().getOperatorHyphenMinusGreaterThanSignKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalImpExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:3224:7: lv_operator_2_2= 'implies'
                            {
                            lv_operator_2_2=(Token)match(input,61,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalImpExprAccess().getOperatorImpliesKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalImpExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpectra.g:3237:4: ( (lv_implication_3_0= ruleTemporalImpExpr ) )
                    // InternalSpectra.g:3238:5: (lv_implication_3_0= ruleTemporalImpExpr )
                    {
                    // InternalSpectra.g:3238:5: (lv_implication_3_0= ruleTemporalImpExpr )
                    // InternalSpectra.g:3239:6: lv_implication_3_0= ruleTemporalImpExpr
                    {

                    						newCompositeNode(grammarAccess.getTemporalImpExprAccess().getImplicationTemporalImpExprParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_implication_3_0=ruleTemporalImpExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemporalImpExprRule());
                    						}
                    						set(
                    							current,
                    							"implication",
                    							lv_implication_3_0,
                    							"tau.smlab.syntech.Spectra.TemporalImpExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalImpExpr"


    // $ANTLR start "entryRuleTemporalIffExpr"
    // InternalSpectra.g:3261:1: entryRuleTemporalIffExpr returns [EObject current=null] : iv_ruleTemporalIffExpr= ruleTemporalIffExpr EOF ;
    public final EObject entryRuleTemporalIffExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalIffExpr = null;


        try {
            // InternalSpectra.g:3261:56: (iv_ruleTemporalIffExpr= ruleTemporalIffExpr EOF )
            // InternalSpectra.g:3262:2: iv_ruleTemporalIffExpr= ruleTemporalIffExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalIffExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalIffExpr=ruleTemporalIffExpr();

            state._fsp--;

             current =iv_ruleTemporalIffExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalIffExpr"


    // $ANTLR start "ruleTemporalIffExpr"
    // InternalSpectra.g:3268:1: ruleTemporalIffExpr returns [EObject current=null] : (this_TemporalOrExpr_0= ruleTemporalOrExpr ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )* ) ;
    public final EObject ruleTemporalIffExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalOrExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3274:2: ( (this_TemporalOrExpr_0= ruleTemporalOrExpr ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )* ) )
            // InternalSpectra.g:3275:2: (this_TemporalOrExpr_0= ruleTemporalOrExpr ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )* )
            {
            // InternalSpectra.g:3275:2: (this_TemporalOrExpr_0= ruleTemporalOrExpr ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )* )
            // InternalSpectra.g:3276:3: this_TemporalOrExpr_0= ruleTemporalOrExpr ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalIffExprAccess().getTemporalOrExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_49);
            this_TemporalOrExpr_0=ruleTemporalOrExpr();

            state._fsp--;


            			current = this_TemporalOrExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3284:3: ( () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=62 && LA65_0<=63)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalSpectra.g:3285:4: () ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) ) ( (lv_elements_3_0= ruleTemporalOrExpr ) )
            	    {
            	    // InternalSpectra.g:3285:4: ()
            	    // InternalSpectra.g:3286:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalIffExprAccess().getTemporalIffExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3292:4: ( ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) ) )
            	    // InternalSpectra.g:3293:5: ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) )
            	    {
            	    // InternalSpectra.g:3293:5: ( (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' ) )
            	    // InternalSpectra.g:3294:6: (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' )
            	    {
            	    // InternalSpectra.g:3294:6: (lv_operator_2_1= '<->' | lv_operator_2_2= 'iff' )
            	    int alt64=2;
            	    int LA64_0 = input.LA(1);

            	    if ( (LA64_0==62) ) {
            	        alt64=1;
            	    }
            	    else if ( (LA64_0==63) ) {
            	        alt64=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 64, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt64) {
            	        case 1 :
            	            // InternalSpectra.g:3295:7: lv_operator_2_1= '<->'
            	            {
            	            lv_operator_2_1=(Token)match(input,62,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalIffExprAccess().getOperatorLessThanSignHyphenMinusGreaterThanSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalIffExprRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3306:7: lv_operator_2_2= 'iff'
            	            {
            	            lv_operator_2_2=(Token)match(input,63,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalIffExprAccess().getOperatorIffKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalIffExprRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3319:4: ( (lv_elements_3_0= ruleTemporalOrExpr ) )
            	    // InternalSpectra.g:3320:5: (lv_elements_3_0= ruleTemporalOrExpr )
            	    {
            	    // InternalSpectra.g:3320:5: (lv_elements_3_0= ruleTemporalOrExpr )
            	    // InternalSpectra.g:3321:6: lv_elements_3_0= ruleTemporalOrExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalIffExprAccess().getElementsTemporalOrExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_49);
            	    lv_elements_3_0=ruleTemporalOrExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalIffExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalOrExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalIffExpr"


    // $ANTLR start "entryRuleTemporalOrExpr"
    // InternalSpectra.g:3343:1: entryRuleTemporalOrExpr returns [EObject current=null] : iv_ruleTemporalOrExpr= ruleTemporalOrExpr EOF ;
    public final EObject entryRuleTemporalOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalOrExpr = null;


        try {
            // InternalSpectra.g:3343:55: (iv_ruleTemporalOrExpr= ruleTemporalOrExpr EOF )
            // InternalSpectra.g:3344:2: iv_ruleTemporalOrExpr= ruleTemporalOrExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalOrExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalOrExpr=ruleTemporalOrExpr();

            state._fsp--;

             current =iv_ruleTemporalOrExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalOrExpr"


    // $ANTLR start "ruleTemporalOrExpr"
    // InternalSpectra.g:3350:1: ruleTemporalOrExpr returns [EObject current=null] : (this_TemporalAndExpr_0= ruleTemporalAndExpr ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )* ) ;
    public final EObject ruleTemporalOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_TemporalAndExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3356:2: ( (this_TemporalAndExpr_0= ruleTemporalAndExpr ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )* ) )
            // InternalSpectra.g:3357:2: (this_TemporalAndExpr_0= ruleTemporalAndExpr ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )* )
            {
            // InternalSpectra.g:3357:2: (this_TemporalAndExpr_0= ruleTemporalAndExpr ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )* )
            // InternalSpectra.g:3358:3: this_TemporalAndExpr_0= ruleTemporalAndExpr ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalOrExprAccess().getTemporalAndExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_50);
            this_TemporalAndExpr_0=ruleTemporalAndExpr();

            state._fsp--;


            			current = this_TemporalAndExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3366:3: ( () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( ((LA67_0>=64 && LA67_0<=66)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalSpectra.g:3367:4: () ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) ) ( (lv_elements_3_0= ruleTemporalAndExpr ) )
            	    {
            	    // InternalSpectra.g:3367:4: ()
            	    // InternalSpectra.g:3368:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalOrExprAccess().getTemporalOrExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3374:4: ( ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) ) )
            	    // InternalSpectra.g:3375:5: ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) )
            	    {
            	    // InternalSpectra.g:3375:5: ( (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' ) )
            	    // InternalSpectra.g:3376:6: (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' )
            	    {
            	    // InternalSpectra.g:3376:6: (lv_operator_2_1= '|' | lv_operator_2_2= 'or' | lv_operator_2_3= 'xor' )
            	    int alt66=3;
            	    switch ( input.LA(1) ) {
            	    case 64:
            	        {
            	        alt66=1;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt66=2;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt66=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 66, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt66) {
            	        case 1 :
            	            // InternalSpectra.g:3377:7: lv_operator_2_1= '|'
            	            {
            	            lv_operator_2_1=(Token)match(input,64,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalOrExprAccess().getOperatorVerticalLineKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalOrExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3388:7: lv_operator_2_2= 'or'
            	            {
            	            lv_operator_2_2=(Token)match(input,65,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalOrExprAccess().getOperatorOrKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalOrExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSpectra.g:3399:7: lv_operator_2_3= 'xor'
            	            {
            	            lv_operator_2_3=(Token)match(input,66,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_3, grammarAccess.getTemporalOrExprAccess().getOperatorXorKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalOrExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3412:4: ( (lv_elements_3_0= ruleTemporalAndExpr ) )
            	    // InternalSpectra.g:3413:5: (lv_elements_3_0= ruleTemporalAndExpr )
            	    {
            	    // InternalSpectra.g:3413:5: (lv_elements_3_0= ruleTemporalAndExpr )
            	    // InternalSpectra.g:3414:6: lv_elements_3_0= ruleTemporalAndExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalOrExprAccess().getElementsTemporalAndExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    lv_elements_3_0=ruleTemporalAndExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalOrExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalAndExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalOrExpr"


    // $ANTLR start "entryRuleTemporalAndExpr"
    // InternalSpectra.g:3436:1: entryRuleTemporalAndExpr returns [EObject current=null] : iv_ruleTemporalAndExpr= ruleTemporalAndExpr EOF ;
    public final EObject entryRuleTemporalAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAndExpr = null;


        try {
            // InternalSpectra.g:3436:56: (iv_ruleTemporalAndExpr= ruleTemporalAndExpr EOF )
            // InternalSpectra.g:3437:2: iv_ruleTemporalAndExpr= ruleTemporalAndExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalAndExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalAndExpr=ruleTemporalAndExpr();

            state._fsp--;

             current =iv_ruleTemporalAndExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalAndExpr"


    // $ANTLR start "ruleTemporalAndExpr"
    // InternalSpectra.g:3443:1: ruleTemporalAndExpr returns [EObject current=null] : (this_TemporalRelationalExpr_0= ruleTemporalRelationalExpr ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )* ) ;
    public final EObject ruleTemporalAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalRelationalExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3449:2: ( (this_TemporalRelationalExpr_0= ruleTemporalRelationalExpr ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )* ) )
            // InternalSpectra.g:3450:2: (this_TemporalRelationalExpr_0= ruleTemporalRelationalExpr ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )* )
            {
            // InternalSpectra.g:3450:2: (this_TemporalRelationalExpr_0= ruleTemporalRelationalExpr ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )* )
            // InternalSpectra.g:3451:3: this_TemporalRelationalExpr_0= ruleTemporalRelationalExpr ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalAndExprAccess().getTemporalRelationalExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_TemporalRelationalExpr_0=ruleTemporalRelationalExpr();

            state._fsp--;


            			current = this_TemporalRelationalExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3459:3: ( () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( ((LA69_0>=67 && LA69_0<=68)) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalSpectra.g:3460:4: () ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) ) ( (lv_elements_3_0= ruleTemporalRelationalExpr ) )
            	    {
            	    // InternalSpectra.g:3460:4: ()
            	    // InternalSpectra.g:3461:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalAndExprAccess().getTemporalAndExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3467:4: ( ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) ) )
            	    // InternalSpectra.g:3468:5: ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) )
            	    {
            	    // InternalSpectra.g:3468:5: ( (lv_operator_2_1= '&' | lv_operator_2_2= 'and' ) )
            	    // InternalSpectra.g:3469:6: (lv_operator_2_1= '&' | lv_operator_2_2= 'and' )
            	    {
            	    // InternalSpectra.g:3469:6: (lv_operator_2_1= '&' | lv_operator_2_2= 'and' )
            	    int alt68=2;
            	    int LA68_0 = input.LA(1);

            	    if ( (LA68_0==67) ) {
            	        alt68=1;
            	    }
            	    else if ( (LA68_0==68) ) {
            	        alt68=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 68, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt68) {
            	        case 1 :
            	            // InternalSpectra.g:3470:7: lv_operator_2_1= '&'
            	            {
            	            lv_operator_2_1=(Token)match(input,67,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalAndExprAccess().getOperatorAmpersandKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalAndExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3481:7: lv_operator_2_2= 'and'
            	            {
            	            lv_operator_2_2=(Token)match(input,68,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalAndExprAccess().getOperatorAndKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalAndExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3494:4: ( (lv_elements_3_0= ruleTemporalRelationalExpr ) )
            	    // InternalSpectra.g:3495:5: (lv_elements_3_0= ruleTemporalRelationalExpr )
            	    {
            	    // InternalSpectra.g:3495:5: (lv_elements_3_0= ruleTemporalRelationalExpr )
            	    // InternalSpectra.g:3496:6: lv_elements_3_0= ruleTemporalRelationalExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalAndExprAccess().getElementsTemporalRelationalExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_elements_3_0=ruleTemporalRelationalExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalAndExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalRelationalExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalAndExpr"


    // $ANTLR start "entryRuleTemporalRelationalExpr"
    // InternalSpectra.g:3518:1: entryRuleTemporalRelationalExpr returns [EObject current=null] : iv_ruleTemporalRelationalExpr= ruleTemporalRelationalExpr EOF ;
    public final EObject entryRuleTemporalRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalRelationalExpr = null;


        try {
            // InternalSpectra.g:3518:63: (iv_ruleTemporalRelationalExpr= ruleTemporalRelationalExpr EOF )
            // InternalSpectra.g:3519:2: iv_ruleTemporalRelationalExpr= ruleTemporalRelationalExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalRelationalExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalRelationalExpr=ruleTemporalRelationalExpr();

            state._fsp--;

             current =iv_ruleTemporalRelationalExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalRelationalExpr"


    // $ANTLR start "ruleTemporalRelationalExpr"
    // InternalSpectra.g:3525:1: ruleTemporalRelationalExpr returns [EObject current=null] : (this_TemporalRemainderExpr_0= ruleTemporalRemainderExpr ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )? ) ;
    public final EObject ruleTemporalRelationalExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        EObject this_TemporalRemainderExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3531:2: ( (this_TemporalRemainderExpr_0= ruleTemporalRemainderExpr ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )? ) )
            // InternalSpectra.g:3532:2: (this_TemporalRemainderExpr_0= ruleTemporalRemainderExpr ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )? )
            {
            // InternalSpectra.g:3532:2: (this_TemporalRemainderExpr_0= ruleTemporalRemainderExpr ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )? )
            // InternalSpectra.g:3533:3: this_TemporalRemainderExpr_0= ruleTemporalRemainderExpr ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )?
            {

            			newCompositeNode(grammarAccess.getTemporalRelationalExprAccess().getTemporalRemainderExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_TemporalRemainderExpr_0=ruleTemporalRemainderExpr();

            state._fsp--;


            			current = this_TemporalRemainderExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3541:3: ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==18||(LA71_0>=69 && LA71_0<=73)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalSpectra.g:3542:4: () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) ) ( (lv_right_3_0= ruleTemporalRemainderExpr ) )
                    {
                    // InternalSpectra.g:3542:4: ()
                    // InternalSpectra.g:3543:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getTemporalRelationalExprAccess().getTemporalRelationalExprLeftAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:3549:4: ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) ) )
                    // InternalSpectra.g:3550:5: ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) )
                    {
                    // InternalSpectra.g:3550:5: ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' ) )
                    // InternalSpectra.g:3551:6: (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' )
                    {
                    // InternalSpectra.g:3551:6: (lv_operator_2_1= '=' | lv_operator_2_2= '!=' | lv_operator_2_3= '<' | lv_operator_2_4= '>' | lv_operator_2_5= '<=' | lv_operator_2_6= '>=' )
                    int alt70=6;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt70=1;
                        }
                        break;
                    case 69:
                        {
                        alt70=2;
                        }
                        break;
                    case 70:
                        {
                        alt70=3;
                        }
                        break;
                    case 71:
                        {
                        alt70=4;
                        }
                        break;
                    case 72:
                        {
                        alt70=5;
                        }
                        break;
                    case 73:
                        {
                        alt70=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // InternalSpectra.g:3552:7: lv_operator_2_1= '='
                            {
                            lv_operator_2_1=(Token)match(input,18,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalRelationalExprAccess().getOperatorEqualsSignKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:3563:7: lv_operator_2_2= '!='
                            {
                            lv_operator_2_2=(Token)match(input,69,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalRelationalExprAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:3574:7: lv_operator_2_3= '<'
                            {
                            lv_operator_2_3=(Token)match(input,70,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_3, grammarAccess.getTemporalRelationalExprAccess().getOperatorLessThanSignKeyword_1_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:3585:7: lv_operator_2_4= '>'
                            {
                            lv_operator_2_4=(Token)match(input,71,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_4, grammarAccess.getTemporalRelationalExprAccess().getOperatorGreaterThanSignKeyword_1_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSpectra.g:3596:7: lv_operator_2_5= '<='
                            {
                            lv_operator_2_5=(Token)match(input,72,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_5, grammarAccess.getTemporalRelationalExprAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSpectra.g:3607:7: lv_operator_2_6= '>='
                            {
                            lv_operator_2_6=(Token)match(input,73,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_6, grammarAccess.getTemporalRelationalExprAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRelationalExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_6, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpectra.g:3620:4: ( (lv_right_3_0= ruleTemporalRemainderExpr ) )
                    // InternalSpectra.g:3621:5: (lv_right_3_0= ruleTemporalRemainderExpr )
                    {
                    // InternalSpectra.g:3621:5: (lv_right_3_0= ruleTemporalRemainderExpr )
                    // InternalSpectra.g:3622:6: lv_right_3_0= ruleTemporalRemainderExpr
                    {

                    						newCompositeNode(grammarAccess.getTemporalRelationalExprAccess().getRightTemporalRemainderExprParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleTemporalRemainderExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemporalRelationalExprRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"tau.smlab.syntech.Spectra.TemporalRemainderExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalRelationalExpr"


    // $ANTLR start "entryRuleTemporalRemainderExpr"
    // InternalSpectra.g:3644:1: entryRuleTemporalRemainderExpr returns [EObject current=null] : iv_ruleTemporalRemainderExpr= ruleTemporalRemainderExpr EOF ;
    public final EObject entryRuleTemporalRemainderExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalRemainderExpr = null;


        try {
            // InternalSpectra.g:3644:62: (iv_ruleTemporalRemainderExpr= ruleTemporalRemainderExpr EOF )
            // InternalSpectra.g:3645:2: iv_ruleTemporalRemainderExpr= ruleTemporalRemainderExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalRemainderExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalRemainderExpr=ruleTemporalRemainderExpr();

            state._fsp--;

             current =iv_ruleTemporalRemainderExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalRemainderExpr"


    // $ANTLR start "ruleTemporalRemainderExpr"
    // InternalSpectra.g:3651:1: ruleTemporalRemainderExpr returns [EObject current=null] : (this_TemporalAdditiveExpr_0= ruleTemporalAdditiveExpr ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )? ) ;
    public final EObject ruleTemporalRemainderExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalAdditiveExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3657:2: ( (this_TemporalAdditiveExpr_0= ruleTemporalAdditiveExpr ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )? ) )
            // InternalSpectra.g:3658:2: (this_TemporalAdditiveExpr_0= ruleTemporalAdditiveExpr ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )? )
            {
            // InternalSpectra.g:3658:2: (this_TemporalAdditiveExpr_0= ruleTemporalAdditiveExpr ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )? )
            // InternalSpectra.g:3659:3: this_TemporalAdditiveExpr_0= ruleTemporalAdditiveExpr ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )?
            {

            			newCompositeNode(grammarAccess.getTemporalRemainderExprAccess().getTemporalAdditiveExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_TemporalAdditiveExpr_0=ruleTemporalAdditiveExpr();

            state._fsp--;


            			current = this_TemporalAdditiveExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3667:3: ( () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=74 && LA73_0<=75)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalSpectra.g:3668:4: () ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) ) ( (lv_right_3_0= ruleTemporalAdditiveExpr ) )
                    {
                    // InternalSpectra.g:3668:4: ()
                    // InternalSpectra.g:3669:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getTemporalRemainderExprAccess().getTemporalRemainderExprLeftAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:3675:4: ( ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) ) )
                    // InternalSpectra.g:3676:5: ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) )
                    {
                    // InternalSpectra.g:3676:5: ( (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' ) )
                    // InternalSpectra.g:3677:6: (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' )
                    {
                    // InternalSpectra.g:3677:6: (lv_operator_2_1= 'mod' | lv_operator_2_2= '%' )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==74) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==75) ) {
                        alt72=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalSpectra.g:3678:7: lv_operator_2_1= 'mod'
                            {
                            lv_operator_2_1=(Token)match(input,74,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalRemainderExprAccess().getOperatorModKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRemainderExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:3689:7: lv_operator_2_2= '%'
                            {
                            lv_operator_2_2=(Token)match(input,75,FOLLOW_12); 

                            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalRemainderExprAccess().getOperatorPercentSignKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTemporalRemainderExprRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpectra.g:3702:4: ( (lv_right_3_0= ruleTemporalAdditiveExpr ) )
                    // InternalSpectra.g:3703:5: (lv_right_3_0= ruleTemporalAdditiveExpr )
                    {
                    // InternalSpectra.g:3703:5: (lv_right_3_0= ruleTemporalAdditiveExpr )
                    // InternalSpectra.g:3704:6: lv_right_3_0= ruleTemporalAdditiveExpr
                    {

                    						newCompositeNode(grammarAccess.getTemporalRemainderExprAccess().getRightTemporalAdditiveExprParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleTemporalAdditiveExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemporalRemainderExprRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"tau.smlab.syntech.Spectra.TemporalAdditiveExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalRemainderExpr"


    // $ANTLR start "entryRuleTemporalAdditiveExpr"
    // InternalSpectra.g:3726:1: entryRuleTemporalAdditiveExpr returns [EObject current=null] : iv_ruleTemporalAdditiveExpr= ruleTemporalAdditiveExpr EOF ;
    public final EObject entryRuleTemporalAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAdditiveExpr = null;


        try {
            // InternalSpectra.g:3726:61: (iv_ruleTemporalAdditiveExpr= ruleTemporalAdditiveExpr EOF )
            // InternalSpectra.g:3727:2: iv_ruleTemporalAdditiveExpr= ruleTemporalAdditiveExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalAdditiveExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalAdditiveExpr=ruleTemporalAdditiveExpr();

            state._fsp--;

             current =iv_ruleTemporalAdditiveExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalAdditiveExpr"


    // $ANTLR start "ruleTemporalAdditiveExpr"
    // InternalSpectra.g:3733:1: ruleTemporalAdditiveExpr returns [EObject current=null] : (this_TemporalMultiplicativeExpr_0= ruleTemporalMultiplicativeExpr ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )* ) ;
    public final EObject ruleTemporalAdditiveExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalMultiplicativeExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3739:2: ( (this_TemporalMultiplicativeExpr_0= ruleTemporalMultiplicativeExpr ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )* ) )
            // InternalSpectra.g:3740:2: (this_TemporalMultiplicativeExpr_0= ruleTemporalMultiplicativeExpr ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )* )
            {
            // InternalSpectra.g:3740:2: (this_TemporalMultiplicativeExpr_0= ruleTemporalMultiplicativeExpr ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )* )
            // InternalSpectra.g:3741:3: this_TemporalMultiplicativeExpr_0= ruleTemporalMultiplicativeExpr ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalAdditiveExprAccess().getTemporalMultiplicativeExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_TemporalMultiplicativeExpr_0=ruleTemporalMultiplicativeExpr();

            state._fsp--;


            			current = this_TemporalMultiplicativeExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3749:3: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==16||LA75_0==76) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalSpectra.g:3750:4: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) )
            	    {
            	    // InternalSpectra.g:3750:4: ()
            	    // InternalSpectra.g:3751:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalAdditiveExprAccess().getTemporalAdditiveExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3757:4: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // InternalSpectra.g:3758:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // InternalSpectra.g:3758:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // InternalSpectra.g:3759:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // InternalSpectra.g:3759:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    int alt74=2;
            	    int LA74_0 = input.LA(1);

            	    if ( (LA74_0==76) ) {
            	        alt74=1;
            	    }
            	    else if ( (LA74_0==16) ) {
            	        alt74=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 74, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt74) {
            	        case 1 :
            	            // InternalSpectra.g:3760:7: lv_operator_2_1= '+'
            	            {
            	            lv_operator_2_1=(Token)match(input,76,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalAdditiveExprAccess().getOperatorPlusSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalAdditiveExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3771:7: lv_operator_2_2= '-'
            	            {
            	            lv_operator_2_2=(Token)match(input,16,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalAdditiveExprAccess().getOperatorHyphenMinusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalAdditiveExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3784:4: ( (lv_elements_3_0= ruleTemporalMultiplicativeExpr ) )
            	    // InternalSpectra.g:3785:5: (lv_elements_3_0= ruleTemporalMultiplicativeExpr )
            	    {
            	    // InternalSpectra.g:3785:5: (lv_elements_3_0= ruleTemporalMultiplicativeExpr )
            	    // InternalSpectra.g:3786:6: lv_elements_3_0= ruleTemporalMultiplicativeExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalAdditiveExprAccess().getElementsTemporalMultiplicativeExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_elements_3_0=ruleTemporalMultiplicativeExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalAdditiveExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalMultiplicativeExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalAdditiveExpr"


    // $ANTLR start "entryRuleTemporalMultiplicativeExpr"
    // InternalSpectra.g:3808:1: entryRuleTemporalMultiplicativeExpr returns [EObject current=null] : iv_ruleTemporalMultiplicativeExpr= ruleTemporalMultiplicativeExpr EOF ;
    public final EObject entryRuleTemporalMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalMultiplicativeExpr = null;


        try {
            // InternalSpectra.g:3808:67: (iv_ruleTemporalMultiplicativeExpr= ruleTemporalMultiplicativeExpr EOF )
            // InternalSpectra.g:3809:2: iv_ruleTemporalMultiplicativeExpr= ruleTemporalMultiplicativeExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalMultiplicativeExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalMultiplicativeExpr=ruleTemporalMultiplicativeExpr();

            state._fsp--;

             current =iv_ruleTemporalMultiplicativeExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalMultiplicativeExpr"


    // $ANTLR start "ruleTemporalMultiplicativeExpr"
    // InternalSpectra.g:3815:1: ruleTemporalMultiplicativeExpr returns [EObject current=null] : (this_TemporalBinaryExpr_0= ruleTemporalBinaryExpr ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )* ) ;
    public final EObject ruleTemporalMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_TemporalBinaryExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3821:2: ( (this_TemporalBinaryExpr_0= ruleTemporalBinaryExpr ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )* ) )
            // InternalSpectra.g:3822:2: (this_TemporalBinaryExpr_0= ruleTemporalBinaryExpr ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )* )
            {
            // InternalSpectra.g:3822:2: (this_TemporalBinaryExpr_0= ruleTemporalBinaryExpr ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )* )
            // InternalSpectra.g:3823:3: this_TemporalBinaryExpr_0= ruleTemporalBinaryExpr ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalMultiplicativeExprAccess().getTemporalBinaryExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_TemporalBinaryExpr_0=ruleTemporalBinaryExpr();

            state._fsp--;


            			current = this_TemporalBinaryExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3831:3: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=77 && LA77_0<=78)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalSpectra.g:3832:4: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_elements_3_0= ruleTemporalBinaryExpr ) )
            	    {
            	    // InternalSpectra.g:3832:4: ()
            	    // InternalSpectra.g:3833:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalMultiplicativeExprAccess().getTemporalMultiplicativeExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3839:4: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // InternalSpectra.g:3840:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // InternalSpectra.g:3840:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // InternalSpectra.g:3841:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // InternalSpectra.g:3841:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    int alt76=2;
            	    int LA76_0 = input.LA(1);

            	    if ( (LA76_0==77) ) {
            	        alt76=1;
            	    }
            	    else if ( (LA76_0==78) ) {
            	        alt76=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 76, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt76) {
            	        case 1 :
            	            // InternalSpectra.g:3842:7: lv_operator_2_1= '*'
            	            {
            	            lv_operator_2_1=(Token)match(input,77,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalMultiplicativeExprAccess().getOperatorAsteriskKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalMultiplicativeExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3853:7: lv_operator_2_2= '/'
            	            {
            	            lv_operator_2_2=(Token)match(input,78,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalMultiplicativeExprAccess().getOperatorSolidusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalMultiplicativeExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3866:4: ( (lv_elements_3_0= ruleTemporalBinaryExpr ) )
            	    // InternalSpectra.g:3867:5: (lv_elements_3_0= ruleTemporalBinaryExpr )
            	    {
            	    // InternalSpectra.g:3867:5: (lv_elements_3_0= ruleTemporalBinaryExpr )
            	    // InternalSpectra.g:3868:6: lv_elements_3_0= ruleTemporalBinaryExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalMultiplicativeExprAccess().getElementsTemporalBinaryExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_elements_3_0=ruleTemporalBinaryExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalMultiplicativeExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalBinaryExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalMultiplicativeExpr"


    // $ANTLR start "entryRuleTemporalBinaryExpr"
    // InternalSpectra.g:3890:1: entryRuleTemporalBinaryExpr returns [EObject current=null] : iv_ruleTemporalBinaryExpr= ruleTemporalBinaryExpr EOF ;
    public final EObject entryRuleTemporalBinaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalBinaryExpr = null;


        try {
            // InternalSpectra.g:3890:59: (iv_ruleTemporalBinaryExpr= ruleTemporalBinaryExpr EOF )
            // InternalSpectra.g:3891:2: iv_ruleTemporalBinaryExpr= ruleTemporalBinaryExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalBinaryExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalBinaryExpr=ruleTemporalBinaryExpr();

            state._fsp--;

             current =iv_ruleTemporalBinaryExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalBinaryExpr"


    // $ANTLR start "ruleTemporalBinaryExpr"
    // InternalSpectra.g:3897:1: ruleTemporalBinaryExpr returns [EObject current=null] : (this_TemporalUnaryExpr_0= ruleTemporalUnaryExpr ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )* ) ;
    public final EObject ruleTemporalBinaryExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        EObject this_TemporalUnaryExpr_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:3903:2: ( (this_TemporalUnaryExpr_0= ruleTemporalUnaryExpr ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )* ) )
            // InternalSpectra.g:3904:2: (this_TemporalUnaryExpr_0= ruleTemporalUnaryExpr ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )* )
            {
            // InternalSpectra.g:3904:2: (this_TemporalUnaryExpr_0= ruleTemporalUnaryExpr ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )* )
            // InternalSpectra.g:3905:3: this_TemporalUnaryExpr_0= ruleTemporalUnaryExpr ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getTemporalBinaryExprAccess().getTemporalUnaryExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_TemporalUnaryExpr_0=ruleTemporalUnaryExpr();

            state._fsp--;


            			current = this_TemporalUnaryExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:3913:3: ( () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=79 && LA79_0<=82)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalSpectra.g:3914:4: () ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) ) ( (lv_elements_3_0= ruleTemporalUnaryExpr ) )
            	    {
            	    // InternalSpectra.g:3914:4: ()
            	    // InternalSpectra.g:3915:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getTemporalBinaryExprAccess().getTemporalBinaryExprElementsAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:3921:4: ( ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) ) )
            	    // InternalSpectra.g:3922:5: ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) )
            	    {
            	    // InternalSpectra.g:3922:5: ( (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' ) )
            	    // InternalSpectra.g:3923:6: (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' )
            	    {
            	    // InternalSpectra.g:3923:6: (lv_operator_2_1= 'S' | lv_operator_2_2= 'SINCE' | lv_operator_2_3= 'T' | lv_operator_2_4= 'TRIGGERED' )
            	    int alt78=4;
            	    switch ( input.LA(1) ) {
            	    case 79:
            	        {
            	        alt78=1;
            	        }
            	        break;
            	    case 80:
            	        {
            	        alt78=2;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt78=3;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt78=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt78) {
            	        case 1 :
            	            // InternalSpectra.g:3924:7: lv_operator_2_1= 'S'
            	            {
            	            lv_operator_2_1=(Token)match(input,79,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getTemporalBinaryExprAccess().getOperatorSKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalBinaryExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSpectra.g:3935:7: lv_operator_2_2= 'SINCE'
            	            {
            	            lv_operator_2_2=(Token)match(input,80,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getTemporalBinaryExprAccess().getOperatorSINCEKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalBinaryExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSpectra.g:3946:7: lv_operator_2_3= 'T'
            	            {
            	            lv_operator_2_3=(Token)match(input,81,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_3, grammarAccess.getTemporalBinaryExprAccess().getOperatorTKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalBinaryExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSpectra.g:3957:7: lv_operator_2_4= 'TRIGGERED'
            	            {
            	            lv_operator_2_4=(Token)match(input,82,FOLLOW_12); 

            	            							newLeafNode(lv_operator_2_4, grammarAccess.getTemporalBinaryExprAccess().getOperatorTRIGGEREDKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getTemporalBinaryExprRule());
            	            							}
            	            							addWithLastConsumed(current, "operator", lv_operator_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSpectra.g:3970:4: ( (lv_elements_3_0= ruleTemporalUnaryExpr ) )
            	    // InternalSpectra.g:3971:5: (lv_elements_3_0= ruleTemporalUnaryExpr )
            	    {
            	    // InternalSpectra.g:3971:5: (lv_elements_3_0= ruleTemporalUnaryExpr )
            	    // InternalSpectra.g:3972:6: lv_elements_3_0= ruleTemporalUnaryExpr
            	    {

            	    						newCompositeNode(grammarAccess.getTemporalBinaryExprAccess().getElementsTemporalUnaryExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_56);
            	    lv_elements_3_0=ruleTemporalUnaryExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemporalBinaryExprRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"tau.smlab.syntech.Spectra.TemporalUnaryExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalBinaryExpr"


    // $ANTLR start "entryRuleTemporalUnaryExpr"
    // InternalSpectra.g:3994:1: entryRuleTemporalUnaryExpr returns [EObject current=null] : iv_ruleTemporalUnaryExpr= ruleTemporalUnaryExpr EOF ;
    public final EObject entryRuleTemporalUnaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalUnaryExpr = null;


        try {
            // InternalSpectra.g:3994:58: (iv_ruleTemporalUnaryExpr= ruleTemporalUnaryExpr EOF )
            // InternalSpectra.g:3995:2: iv_ruleTemporalUnaryExpr= ruleTemporalUnaryExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalUnaryExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalUnaryExpr=ruleTemporalUnaryExpr();

            state._fsp--;

             current =iv_ruleTemporalUnaryExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalUnaryExpr"


    // $ANTLR start "ruleTemporalUnaryExpr"
    // InternalSpectra.g:4001:1: ruleTemporalUnaryExpr returns [EObject current=null] : (this_TemporalPrimaryExpr_0= ruleTemporalPrimaryExpr | ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) ) ) ;
    public final EObject ruleTemporalUnaryExpr() throws RecognitionException {
        EObject current = null;

        Token lv_kinds_2_1=null;
        Token lv_kinds_2_2=null;
        Token lv_kinds_4_1=null;
        Token lv_kinds_4_2=null;
        Token lv_kinds_6_1=null;
        Token lv_kinds_6_2=null;
        EObject this_TemporalPrimaryExpr_0 = null;

        EObject lv_tue_3_0 = null;

        EObject lv_tue_5_0 = null;

        EObject lv_tue_7_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:4007:2: ( (this_TemporalPrimaryExpr_0= ruleTemporalPrimaryExpr | ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) ) ) )
            // InternalSpectra.g:4008:2: (this_TemporalPrimaryExpr_0= ruleTemporalPrimaryExpr | ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) ) )
            {
            // InternalSpectra.g:4008:2: (this_TemporalPrimaryExpr_0= ruleTemporalPrimaryExpr | ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID||LA84_0==RULE_INT||LA84_0==16||LA84_0==26||LA84_0==28||(LA84_0>=89 && LA84_0<=90)||(LA84_0>=98 && LA84_0<=101)) ) {
                alt84=1;
            }
            else if ( ((LA84_0>=83 && LA84_0<=88)) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalSpectra.g:4009:3: this_TemporalPrimaryExpr_0= ruleTemporalPrimaryExpr
                    {

                    			newCompositeNode(grammarAccess.getTemporalUnaryExprAccess().getTemporalPrimaryExprParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalPrimaryExpr_0=ruleTemporalPrimaryExpr();

                    state._fsp--;


                    			current = this_TemporalPrimaryExpr_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:4018:3: ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) )
                    {
                    // InternalSpectra.g:4018:3: ( () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) ) )
                    // InternalSpectra.g:4019:4: () ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) )
                    {
                    // InternalSpectra.g:4019:4: ()
                    // InternalSpectra.g:4020:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTemporalUnaryExprAccess().getTemporalUnaryExprAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:4026:4: ( ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) ) | ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) ) )
                    int alt83=3;
                    switch ( input.LA(1) ) {
                    case 83:
                    case 84:
                        {
                        alt83=1;
                        }
                        break;
                    case 85:
                    case 86:
                        {
                        alt83=2;
                        }
                        break;
                    case 87:
                    case 88:
                        {
                        alt83=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }

                    switch (alt83) {
                        case 1 :
                            // InternalSpectra.g:4027:5: ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) )
                            {
                            // InternalSpectra.g:4027:5: ( ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) ) )
                            // InternalSpectra.g:4028:6: ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) ) ( (lv_tue_3_0= ruleTemporalUnaryExpr ) )
                            {
                            // InternalSpectra.g:4028:6: ( ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) ) )
                            // InternalSpectra.g:4029:7: ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) )
                            {
                            // InternalSpectra.g:4029:7: ( (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' ) )
                            // InternalSpectra.g:4030:8: (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' )
                            {
                            // InternalSpectra.g:4030:8: (lv_kinds_2_1= 'Y' | lv_kinds_2_2= 'PREV' )
                            int alt80=2;
                            int LA80_0 = input.LA(1);

                            if ( (LA80_0==83) ) {
                                alt80=1;
                            }
                            else if ( (LA80_0==84) ) {
                                alt80=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 80, 0, input);

                                throw nvae;
                            }
                            switch (alt80) {
                                case 1 :
                                    // InternalSpectra.g:4031:9: lv_kinds_2_1= 'Y'
                                    {
                                    lv_kinds_2_1=(Token)match(input,83,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_2_1, grammarAccess.getTemporalUnaryExprAccess().getKindsYKeyword_1_1_0_0_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_2_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4042:9: lv_kinds_2_2= 'PREV'
                                    {
                                    lv_kinds_2_2=(Token)match(input,84,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_2_2, grammarAccess.getTemporalUnaryExprAccess().getKindsPREVKeyword_1_1_0_0_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_2_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }

                            // InternalSpectra.g:4055:6: ( (lv_tue_3_0= ruleTemporalUnaryExpr ) )
                            // InternalSpectra.g:4056:7: (lv_tue_3_0= ruleTemporalUnaryExpr )
                            {
                            // InternalSpectra.g:4056:7: (lv_tue_3_0= ruleTemporalUnaryExpr )
                            // InternalSpectra.g:4057:8: lv_tue_3_0= ruleTemporalUnaryExpr
                            {

                            								newCompositeNode(grammarAccess.getTemporalUnaryExprAccess().getTueTemporalUnaryExprParserRuleCall_1_1_0_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_tue_3_0=ruleTemporalUnaryExpr();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTemporalUnaryExprRule());
                            								}
                            								set(
                            									current,
                            									"tue",
                            									lv_tue_3_0,
                            									"tau.smlab.syntech.Spectra.TemporalUnaryExpr");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:4076:5: ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) )
                            {
                            // InternalSpectra.g:4076:5: ( ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) ) )
                            // InternalSpectra.g:4077:6: ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) ) ( (lv_tue_5_0= ruleTemporalUnaryExpr ) )
                            {
                            // InternalSpectra.g:4077:6: ( ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) ) )
                            // InternalSpectra.g:4078:7: ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) )
                            {
                            // InternalSpectra.g:4078:7: ( (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' ) )
                            // InternalSpectra.g:4079:8: (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' )
                            {
                            // InternalSpectra.g:4079:8: (lv_kinds_4_1= 'H' | lv_kinds_4_2= 'HISTORICALLY' )
                            int alt81=2;
                            int LA81_0 = input.LA(1);

                            if ( (LA81_0==85) ) {
                                alt81=1;
                            }
                            else if ( (LA81_0==86) ) {
                                alt81=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 81, 0, input);

                                throw nvae;
                            }
                            switch (alt81) {
                                case 1 :
                                    // InternalSpectra.g:4080:9: lv_kinds_4_1= 'H'
                                    {
                                    lv_kinds_4_1=(Token)match(input,85,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_4_1, grammarAccess.getTemporalUnaryExprAccess().getKindsHKeyword_1_1_1_0_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_4_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4091:9: lv_kinds_4_2= 'HISTORICALLY'
                                    {
                                    lv_kinds_4_2=(Token)match(input,86,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_4_2, grammarAccess.getTemporalUnaryExprAccess().getKindsHISTORICALLYKeyword_1_1_1_0_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_4_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }

                            // InternalSpectra.g:4104:6: ( (lv_tue_5_0= ruleTemporalUnaryExpr ) )
                            // InternalSpectra.g:4105:7: (lv_tue_5_0= ruleTemporalUnaryExpr )
                            {
                            // InternalSpectra.g:4105:7: (lv_tue_5_0= ruleTemporalUnaryExpr )
                            // InternalSpectra.g:4106:8: lv_tue_5_0= ruleTemporalUnaryExpr
                            {

                            								newCompositeNode(grammarAccess.getTemporalUnaryExprAccess().getTueTemporalUnaryExprParserRuleCall_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_tue_5_0=ruleTemporalUnaryExpr();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTemporalUnaryExprRule());
                            								}
                            								set(
                            									current,
                            									"tue",
                            									lv_tue_5_0,
                            									"tau.smlab.syntech.Spectra.TemporalUnaryExpr");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:4125:5: ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) )
                            {
                            // InternalSpectra.g:4125:5: ( ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) ) )
                            // InternalSpectra.g:4126:6: ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) ) ( (lv_tue_7_0= ruleTemporalUnaryExpr ) )
                            {
                            // InternalSpectra.g:4126:6: ( ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) ) )
                            // InternalSpectra.g:4127:7: ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) )
                            {
                            // InternalSpectra.g:4127:7: ( (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' ) )
                            // InternalSpectra.g:4128:8: (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' )
                            {
                            // InternalSpectra.g:4128:8: (lv_kinds_6_1= 'O' | lv_kinds_6_2= 'ONCE' )
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( (LA82_0==87) ) {
                                alt82=1;
                            }
                            else if ( (LA82_0==88) ) {
                                alt82=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 82, 0, input);

                                throw nvae;
                            }
                            switch (alt82) {
                                case 1 :
                                    // InternalSpectra.g:4129:9: lv_kinds_6_1= 'O'
                                    {
                                    lv_kinds_6_1=(Token)match(input,87,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_6_1, grammarAccess.getTemporalUnaryExprAccess().getKindsOKeyword_1_1_2_0_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_6_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4140:9: lv_kinds_6_2= 'ONCE'
                                    {
                                    lv_kinds_6_2=(Token)match(input,88,FOLLOW_12); 

                                    									newLeafNode(lv_kinds_6_2, grammarAccess.getTemporalUnaryExprAccess().getKindsONCEKeyword_1_1_2_0_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalUnaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "kinds", lv_kinds_6_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }

                            // InternalSpectra.g:4153:6: ( (lv_tue_7_0= ruleTemporalUnaryExpr ) )
                            // InternalSpectra.g:4154:7: (lv_tue_7_0= ruleTemporalUnaryExpr )
                            {
                            // InternalSpectra.g:4154:7: (lv_tue_7_0= ruleTemporalUnaryExpr )
                            // InternalSpectra.g:4155:8: lv_tue_7_0= ruleTemporalUnaryExpr
                            {

                            								newCompositeNode(grammarAccess.getTemporalUnaryExprAccess().getTueTemporalUnaryExprParserRuleCall_1_1_2_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_tue_7_0=ruleTemporalUnaryExpr();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTemporalUnaryExprRule());
                            								}
                            								set(
                            									current,
                            									"tue",
                            									lv_tue_7_0,
                            									"tau.smlab.syntech.Spectra.TemporalUnaryExpr");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalUnaryExpr"


    // $ANTLR start "entryRuleTemporalPrimaryExpr"
    // InternalSpectra.g:4179:1: entryRuleTemporalPrimaryExpr returns [EObject current=null] : iv_ruleTemporalPrimaryExpr= ruleTemporalPrimaryExpr EOF ;
    public final EObject entryRuleTemporalPrimaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalPrimaryExpr = null;


        try {
            // InternalSpectra.g:4179:60: (iv_ruleTemporalPrimaryExpr= ruleTemporalPrimaryExpr EOF )
            // InternalSpectra.g:4180:2: iv_ruleTemporalPrimaryExpr= ruleTemporalPrimaryExpr EOF
            {
             newCompositeNode(grammarAccess.getTemporalPrimaryExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalPrimaryExpr=ruleTemporalPrimaryExpr();

            state._fsp--;

             current =iv_ruleTemporalPrimaryExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalPrimaryExpr"


    // $ANTLR start "ruleTemporalPrimaryExpr"
    // InternalSpectra.g:4186:1: ruleTemporalPrimaryExpr returns [EObject current=null] : (this_Constant_0= ruleConstant | (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' ) | ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) ) ) ;
    public final EObject ruleTemporalPrimaryExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_operator_12_1=null;
        Token lv_operator_12_2=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_operator_18_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token lv_operator_22_0=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token lv_operator_28_0=null;
        Token otherlv_29=null;
        Token lv_operator_30_0=null;
        Token otherlv_31=null;
        Token lv_operator_32_0=null;
        Token otherlv_33=null;
        Token lv_operator_34_0=null;
        Token otherlv_35=null;
        Token lv_operator_36_0=null;
        Token otherlv_37=null;
        Token lv_operator_38_0=null;
        EObject this_Constant_0 = null;

        EObject this_QuantifierExpr_2 = null;

        EObject lv_predPattParams_7_0 = null;

        EObject lv_predPattParams_9_0 = null;

        EObject lv_tpe_13_0 = null;

        EObject lv_index_16_0 = null;

        EObject lv_temporalExpression_20_0 = null;

        EObject lv_regexp_24_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:4192:2: ( (this_Constant_0= ruleConstant | (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' ) | ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) ) ) )
            // InternalSpectra.g:4193:2: (this_Constant_0= ruleConstant | (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' ) | ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) ) )
            {
            // InternalSpectra.g:4193:2: (this_Constant_0= ruleConstant | (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' ) | ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) ) )
            int alt91=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt91=1;
                }
                break;
            case 28:
                {
                alt91=2;
                }
                break;
            case RULE_ID:
            case 16:
            case 26:
            case 89:
            case 90:
                {
                alt91=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalSpectra.g:4194:3: this_Constant_0= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_0=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:4203:3: (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' )
                    {
                    // InternalSpectra.g:4203:3: (otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')' )
                    // InternalSpectra.g:4204:4: otherlv_1= '(' this_QuantifierExpr_2= ruleQuantifierExpr otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getTemporalPrimaryExprAccess().getLeftParenthesisKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getQuantifierExprParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_28);
                    this_QuantifierExpr_2=ruleQuantifierExpr();

                    state._fsp--;


                    				current = this_QuantifierExpr_2;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_3=(Token)match(input,29,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getTemporalPrimaryExprAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:4222:3: ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) )
                    {
                    // InternalSpectra.g:4222:3: ( () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) ) )
                    // InternalSpectra.g:4223:4: () ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) )
                    {
                    // InternalSpectra.g:4223:4: ()
                    // InternalSpectra.g:4224:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTemporalPrimaryExprAccess().getTemporalPrimaryExprAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:4230:4: ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) )
                    int alt90=11;
                    alt90 = dfa90.predict(input);
                    switch (alt90) {
                        case 1 :
                            // InternalSpectra.g:4231:5: ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) )
                            {
                            // InternalSpectra.g:4231:5: ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) )
                            // InternalSpectra.g:4232:6: ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' )
                            {
                            // InternalSpectra.g:4232:6: ( (otherlv_5= RULE_ID ) )
                            // InternalSpectra.g:4233:7: (otherlv_5= RULE_ID )
                            {
                            // InternalSpectra.g:4233:7: (otherlv_5= RULE_ID )
                            // InternalSpectra.g:4234:8: otherlv_5= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_35); 

                            								newLeafNode(otherlv_5, grammarAccess.getTemporalPrimaryExprAccess().getPredPattPredicateOrPatternReferrableCrossReference_2_1_0_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4245:6: ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' )
                            int alt86=2;
                            int LA86_0 = input.LA(1);

                            if ( (LA86_0==28) ) {
                                alt86=1;
                            }
                            else if ( (LA86_0==48) ) {
                                alt86=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 86, 0, input);

                                throw nvae;
                            }
                            switch (alt86) {
                                case 1 :
                                    // InternalSpectra.g:4246:7: (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' )
                                    {
                                    // InternalSpectra.g:4246:7: (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' )
                                    // InternalSpectra.g:4247:8: otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')'
                                    {
                                    otherlv_6=(Token)match(input,28,FOLLOW_12); 

                                    								newLeafNode(otherlv_6, grammarAccess.getTemporalPrimaryExprAccess().getLeftParenthesisKeyword_2_1_0_1_0_0());
                                    							
                                    // InternalSpectra.g:4251:8: ( (lv_predPattParams_7_0= ruleTemporalInExpr ) )
                                    // InternalSpectra.g:4252:9: (lv_predPattParams_7_0= ruleTemporalInExpr )
                                    {
                                    // InternalSpectra.g:4252:9: (lv_predPattParams_7_0= ruleTemporalInExpr )
                                    // InternalSpectra.g:4253:10: lv_predPattParams_7_0= ruleTemporalInExpr
                                    {

                                    										newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getPredPattParamsTemporalInExprParserRuleCall_2_1_0_1_0_1_0());
                                    									
                                    pushFollow(FOLLOW_57);
                                    lv_predPattParams_7_0=ruleTemporalInExpr();

                                    state._fsp--;


                                    										if (current==null) {
                                    											current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                                    										}
                                    										add(
                                    											current,
                                    											"predPattParams",
                                    											lv_predPattParams_7_0,
                                    											"tau.smlab.syntech.Spectra.TemporalInExpr");
                                    										afterParserOrEnumRuleCall();
                                    									

                                    }


                                    }

                                    // InternalSpectra.g:4270:8: (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )*
                                    loop85:
                                    do {
                                        int alt85=2;
                                        int LA85_0 = input.LA(1);

                                        if ( (LA85_0==24) ) {
                                            alt85=1;
                                        }


                                        switch (alt85) {
                                    	case 1 :
                                    	    // InternalSpectra.g:4271:9: otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) )
                                    	    {
                                    	    otherlv_8=(Token)match(input,24,FOLLOW_12); 

                                    	    									newLeafNode(otherlv_8, grammarAccess.getTemporalPrimaryExprAccess().getCommaKeyword_2_1_0_1_0_2_0());
                                    	    								
                                    	    // InternalSpectra.g:4275:9: ( (lv_predPattParams_9_0= ruleTemporalInExpr ) )
                                    	    // InternalSpectra.g:4276:10: (lv_predPattParams_9_0= ruleTemporalInExpr )
                                    	    {
                                    	    // InternalSpectra.g:4276:10: (lv_predPattParams_9_0= ruleTemporalInExpr )
                                    	    // InternalSpectra.g:4277:11: lv_predPattParams_9_0= ruleTemporalInExpr
                                    	    {

                                    	    											newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getPredPattParamsTemporalInExprParserRuleCall_2_1_0_1_0_2_1_0());
                                    	    										
                                    	    pushFollow(FOLLOW_57);
                                    	    lv_predPattParams_9_0=ruleTemporalInExpr();

                                    	    state._fsp--;


                                    	    											if (current==null) {
                                    	    												current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                                    	    											}
                                    	    											add(
                                    	    												current,
                                    	    												"predPattParams",
                                    	    												lv_predPattParams_9_0,
                                    	    												"tau.smlab.syntech.Spectra.TemporalInExpr");
                                    	    											afterParserOrEnumRuleCall();
                                    	    										

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop85;
                                        }
                                    } while (true);

                                    otherlv_10=(Token)match(input,29,FOLLOW_2); 

                                    								newLeafNode(otherlv_10, grammarAccess.getTemporalPrimaryExprAccess().getRightParenthesisKeyword_2_1_0_1_0_3());
                                    							

                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4301:7: otherlv_11= '()'
                                    {
                                    otherlv_11=(Token)match(input,48,FOLLOW_2); 

                                    							newLeafNode(otherlv_11, grammarAccess.getTemporalPrimaryExprAccess().getLeftParenthesisRightParenthesisKeyword_2_1_0_1_1());
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:4308:5: ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) )
                            {
                            // InternalSpectra.g:4308:5: ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) )
                            // InternalSpectra.g:4309:6: ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) )
                            {
                            // InternalSpectra.g:4309:6: ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) )
                            // InternalSpectra.g:4310:7: ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) )
                            {
                            // InternalSpectra.g:4310:7: ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) )
                            // InternalSpectra.g:4311:8: (lv_operator_12_1= '-' | lv_operator_12_2= '!' )
                            {
                            // InternalSpectra.g:4311:8: (lv_operator_12_1= '-' | lv_operator_12_2= '!' )
                            int alt87=2;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==16) ) {
                                alt87=1;
                            }
                            else if ( (LA87_0==89) ) {
                                alt87=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 0, input);

                                throw nvae;
                            }
                            switch (alt87) {
                                case 1 :
                                    // InternalSpectra.g:4312:9: lv_operator_12_1= '-'
                                    {
                                    lv_operator_12_1=(Token)match(input,16,FOLLOW_58); 

                                    									newLeafNode(lv_operator_12_1, grammarAccess.getTemporalPrimaryExprAccess().getOperatorHyphenMinusKeyword_2_1_1_0_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "operator", lv_operator_12_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4323:9: lv_operator_12_2= '!'
                                    {
                                    lv_operator_12_2=(Token)match(input,89,FOLLOW_58); 

                                    									newLeafNode(lv_operator_12_2, grammarAccess.getTemporalPrimaryExprAccess().getOperatorExclamationMarkKeyword_2_1_1_0_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                                    									}
                                    									setWithLastConsumed(current, "operator", lv_operator_12_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }

                            // InternalSpectra.g:4336:6: ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) )
                            // InternalSpectra.g:4337:7: (lv_tpe_13_0= ruleTemporalPrimaryExpr )
                            {
                            // InternalSpectra.g:4337:7: (lv_tpe_13_0= ruleTemporalPrimaryExpr )
                            // InternalSpectra.g:4338:8: lv_tpe_13_0= ruleTemporalPrimaryExpr
                            {

                            								newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getTpeTemporalPrimaryExprParserRuleCall_2_1_1_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_tpe_13_0=ruleTemporalPrimaryExpr();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								set(
                            									current,
                            									"tpe",
                            									lv_tpe_13_0,
                            									"tau.smlab.syntech.Spectra.TemporalPrimaryExpr");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:4357:5: ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* )
                            {
                            // InternalSpectra.g:4357:5: ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* )
                            // InternalSpectra.g:4358:6: ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )*
                            {
                            // InternalSpectra.g:4358:6: ( (otherlv_14= RULE_ID ) )
                            // InternalSpectra.g:4359:7: (otherlv_14= RULE_ID )
                            {
                            // InternalSpectra.g:4359:7: (otherlv_14= RULE_ID )
                            // InternalSpectra.g:4360:8: otherlv_14= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_14=(Token)match(input,RULE_ID,FOLLOW_38); 

                            								newLeafNode(otherlv_14, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_2_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4371:6: (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )*
                            loop88:
                            do {
                                int alt88=2;
                                int LA88_0 = input.LA(1);

                                if ( (LA88_0==21) ) {
                                    alt88=1;
                                }


                                switch (alt88) {
                            	case 1 :
                            	    // InternalSpectra.g:4372:7: otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']'
                            	    {
                            	    otherlv_15=(Token)match(input,21,FOLLOW_12); 

                            	    							newLeafNode(otherlv_15, grammarAccess.getTemporalPrimaryExprAccess().getLeftSquareBracketKeyword_2_1_2_1_0());
                            	    						
                            	    // InternalSpectra.g:4376:7: ( (lv_index_16_0= ruleTemporalInExpr ) )
                            	    // InternalSpectra.g:4377:8: (lv_index_16_0= ruleTemporalInExpr )
                            	    {
                            	    // InternalSpectra.g:4377:8: (lv_index_16_0= ruleTemporalInExpr )
                            	    // InternalSpectra.g:4378:9: lv_index_16_0= ruleTemporalInExpr
                            	    {

                            	    									newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getIndexTemporalInExprParserRuleCall_2_1_2_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_21);
                            	    lv_index_16_0=ruleTemporalInExpr();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"index",
                            	    										lv_index_16_0,
                            	    										"tau.smlab.syntech.Spectra.TemporalInExpr");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }

                            	    otherlv_17=(Token)match(input,22,FOLLOW_38); 

                            	    							newLeafNode(otherlv_17, grammarAccess.getTemporalPrimaryExprAccess().getRightSquareBracketKeyword_2_1_2_1_2());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop88;
                                }
                            } while (true);


                            }


                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:4402:5: ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' )
                            {
                            // InternalSpectra.g:4402:5: ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' )
                            // InternalSpectra.g:4403:6: ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')'
                            {
                            // InternalSpectra.g:4403:6: ( (lv_operator_18_0= 'next' ) )
                            // InternalSpectra.g:4404:7: (lv_operator_18_0= 'next' )
                            {
                            // InternalSpectra.g:4404:7: (lv_operator_18_0= 'next' )
                            // InternalSpectra.g:4405:8: lv_operator_18_0= 'next'
                            {
                            lv_operator_18_0=(Token)match(input,90,FOLLOW_27); 

                            								newLeafNode(lv_operator_18_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorNextKeyword_2_1_3_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_18_0, "next");
                            							

                            }


                            }

                            otherlv_19=(Token)match(input,28,FOLLOW_12); 

                            						newLeafNode(otherlv_19, grammarAccess.getTemporalPrimaryExprAccess().getLeftParenthesisKeyword_2_1_3_1());
                            					
                            // InternalSpectra.g:4421:6: ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) )
                            // InternalSpectra.g:4422:7: (lv_temporalExpression_20_0= ruleTemporalInExpr )
                            {
                            // InternalSpectra.g:4422:7: (lv_temporalExpression_20_0= ruleTemporalInExpr )
                            // InternalSpectra.g:4423:8: lv_temporalExpression_20_0= ruleTemporalInExpr
                            {

                            								newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getTemporalExpressionTemporalInExprParserRuleCall_2_1_3_2_0());
                            							
                            pushFollow(FOLLOW_28);
                            lv_temporalExpression_20_0=ruleTemporalInExpr();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								set(
                            									current,
                            									"temporalExpression",
                            									lv_temporalExpression_20_0,
                            									"tau.smlab.syntech.Spectra.TemporalInExpr");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            otherlv_21=(Token)match(input,29,FOLLOW_2); 

                            						newLeafNode(otherlv_21, grammarAccess.getTemporalPrimaryExprAccess().getRightParenthesisKeyword_2_1_3_3());
                            					

                            }


                            }
                            break;
                        case 5 :
                            // InternalSpectra.g:4446:5: ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' )
                            {
                            // InternalSpectra.g:4446:5: ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' )
                            // InternalSpectra.g:4447:6: ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')'
                            {
                            // InternalSpectra.g:4447:6: ( (lv_operator_22_0= 'regexp' ) )
                            // InternalSpectra.g:4448:7: (lv_operator_22_0= 'regexp' )
                            {
                            // InternalSpectra.g:4448:7: (lv_operator_22_0= 'regexp' )
                            // InternalSpectra.g:4449:8: lv_operator_22_0= 'regexp'
                            {
                            lv_operator_22_0=(Token)match(input,26,FOLLOW_27); 

                            								newLeafNode(lv_operator_22_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorRegexpKeyword_2_1_4_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_22_0, "regexp");
                            							

                            }


                            }

                            otherlv_23=(Token)match(input,28,FOLLOW_44); 

                            						newLeafNode(otherlv_23, grammarAccess.getTemporalPrimaryExprAccess().getLeftParenthesisKeyword_2_1_4_1());
                            					
                            // InternalSpectra.g:4465:6: ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) )
                            int alt89=2;
                            int LA89_0 = input.LA(1);

                            if ( (LA89_0==21||LA89_0==28||LA89_0==48||(LA89_0>=98 && LA89_0<=101)||LA89_0==105) ) {
                                alt89=1;
                            }
                            else if ( (LA89_0==RULE_ID) ) {
                                alt89=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 89, 0, input);

                                throw nvae;
                            }
                            switch (alt89) {
                                case 1 :
                                    // InternalSpectra.g:4466:7: ( (lv_regexp_24_0= ruleRegExp ) )
                                    {
                                    // InternalSpectra.g:4466:7: ( (lv_regexp_24_0= ruleRegExp ) )
                                    // InternalSpectra.g:4467:8: (lv_regexp_24_0= ruleRegExp )
                                    {
                                    // InternalSpectra.g:4467:8: (lv_regexp_24_0= ruleRegExp )
                                    // InternalSpectra.g:4468:9: lv_regexp_24_0= ruleRegExp
                                    {

                                    									newCompositeNode(grammarAccess.getTemporalPrimaryExprAccess().getRegexpRegExpParserRuleCall_2_1_4_2_0_0());
                                    								
                                    pushFollow(FOLLOW_28);
                                    lv_regexp_24_0=ruleRegExp();

                                    state._fsp--;


                                    									if (current==null) {
                                    										current = createModelElementForParent(grammarAccess.getTemporalPrimaryExprRule());
                                    									}
                                    									set(
                                    										current,
                                    										"regexp",
                                    										lv_regexp_24_0,
                                    										"tau.smlab.syntech.Spectra.RegExp");
                                    									afterParserOrEnumRuleCall();
                                    								

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:4486:7: ( (otherlv_25= RULE_ID ) )
                                    {
                                    // InternalSpectra.g:4486:7: ( (otherlv_25= RULE_ID ) )
                                    // InternalSpectra.g:4487:8: (otherlv_25= RULE_ID )
                                    {
                                    // InternalSpectra.g:4487:8: (otherlv_25= RULE_ID )
                                    // InternalSpectra.g:4488:9: otherlv_25= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                                    									}
                                    								
                                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_28); 

                                    									newLeafNode(otherlv_25, grammarAccess.getTemporalPrimaryExprAccess().getRegexpPointerDefineRegExpDeclCrossReference_2_1_4_2_1_0());
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_26=(Token)match(input,29,FOLLOW_2); 

                            						newLeafNode(otherlv_26, grammarAccess.getTemporalPrimaryExprAccess().getRightParenthesisKeyword_2_1_4_3());
                            					

                            }


                            }
                            break;
                        case 6 :
                            // InternalSpectra.g:4506:5: ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) )
                            {
                            // InternalSpectra.g:4506:5: ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) )
                            // InternalSpectra.g:4507:6: ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) )
                            {
                            // InternalSpectra.g:4507:6: ( (otherlv_27= RULE_ID ) )
                            // InternalSpectra.g:4508:7: (otherlv_27= RULE_ID )
                            {
                            // InternalSpectra.g:4508:7: (otherlv_27= RULE_ID )
                            // InternalSpectra.g:4509:8: otherlv_27= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_27=(Token)match(input,RULE_ID,FOLLOW_59); 

                            								newLeafNode(otherlv_27, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_5_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4520:6: ( (lv_operator_28_0= '.all' ) )
                            // InternalSpectra.g:4521:7: (lv_operator_28_0= '.all' )
                            {
                            // InternalSpectra.g:4521:7: (lv_operator_28_0= '.all' )
                            // InternalSpectra.g:4522:8: lv_operator_28_0= '.all'
                            {
                            lv_operator_28_0=(Token)match(input,91,FOLLOW_2); 

                            								newLeafNode(lv_operator_28_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorAllKeyword_2_1_5_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_28_0, ".all");
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 7 :
                            // InternalSpectra.g:4536:5: ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) )
                            {
                            // InternalSpectra.g:4536:5: ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) )
                            // InternalSpectra.g:4537:6: ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) )
                            {
                            // InternalSpectra.g:4537:6: ( (otherlv_29= RULE_ID ) )
                            // InternalSpectra.g:4538:7: (otherlv_29= RULE_ID )
                            {
                            // InternalSpectra.g:4538:7: (otherlv_29= RULE_ID )
                            // InternalSpectra.g:4539:8: otherlv_29= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_29=(Token)match(input,RULE_ID,FOLLOW_60); 

                            								newLeafNode(otherlv_29, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_6_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4550:6: ( (lv_operator_30_0= '.any' ) )
                            // InternalSpectra.g:4551:7: (lv_operator_30_0= '.any' )
                            {
                            // InternalSpectra.g:4551:7: (lv_operator_30_0= '.any' )
                            // InternalSpectra.g:4552:8: lv_operator_30_0= '.any'
                            {
                            lv_operator_30_0=(Token)match(input,92,FOLLOW_2); 

                            								newLeafNode(lv_operator_30_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorAnyKeyword_2_1_6_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_30_0, ".any");
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 8 :
                            // InternalSpectra.g:4566:5: ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) )
                            {
                            // InternalSpectra.g:4566:5: ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) )
                            // InternalSpectra.g:4567:6: ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) )
                            {
                            // InternalSpectra.g:4567:6: ( (otherlv_31= RULE_ID ) )
                            // InternalSpectra.g:4568:7: (otherlv_31= RULE_ID )
                            {
                            // InternalSpectra.g:4568:7: (otherlv_31= RULE_ID )
                            // InternalSpectra.g:4569:8: otherlv_31= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_31=(Token)match(input,RULE_ID,FOLLOW_61); 

                            								newLeafNode(otherlv_31, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_7_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4580:6: ( (lv_operator_32_0= '.prod' ) )
                            // InternalSpectra.g:4581:7: (lv_operator_32_0= '.prod' )
                            {
                            // InternalSpectra.g:4581:7: (lv_operator_32_0= '.prod' )
                            // InternalSpectra.g:4582:8: lv_operator_32_0= '.prod'
                            {
                            lv_operator_32_0=(Token)match(input,93,FOLLOW_2); 

                            								newLeafNode(lv_operator_32_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorProdKeyword_2_1_7_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_32_0, ".prod");
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 9 :
                            // InternalSpectra.g:4596:5: ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) )
                            {
                            // InternalSpectra.g:4596:5: ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) )
                            // InternalSpectra.g:4597:6: ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) )
                            {
                            // InternalSpectra.g:4597:6: ( (otherlv_33= RULE_ID ) )
                            // InternalSpectra.g:4598:7: (otherlv_33= RULE_ID )
                            {
                            // InternalSpectra.g:4598:7: (otherlv_33= RULE_ID )
                            // InternalSpectra.g:4599:8: otherlv_33= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_33=(Token)match(input,RULE_ID,FOLLOW_62); 

                            								newLeafNode(otherlv_33, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_8_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4610:6: ( (lv_operator_34_0= '.sum' ) )
                            // InternalSpectra.g:4611:7: (lv_operator_34_0= '.sum' )
                            {
                            // InternalSpectra.g:4611:7: (lv_operator_34_0= '.sum' )
                            // InternalSpectra.g:4612:8: lv_operator_34_0= '.sum'
                            {
                            lv_operator_34_0=(Token)match(input,94,FOLLOW_2); 

                            								newLeafNode(lv_operator_34_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorSumKeyword_2_1_8_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_34_0, ".sum");
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 10 :
                            // InternalSpectra.g:4626:5: ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) )
                            {
                            // InternalSpectra.g:4626:5: ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) )
                            // InternalSpectra.g:4627:6: ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) )
                            {
                            // InternalSpectra.g:4627:6: ( (otherlv_35= RULE_ID ) )
                            // InternalSpectra.g:4628:7: (otherlv_35= RULE_ID )
                            {
                            // InternalSpectra.g:4628:7: (otherlv_35= RULE_ID )
                            // InternalSpectra.g:4629:8: otherlv_35= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_35=(Token)match(input,RULE_ID,FOLLOW_63); 

                            								newLeafNode(otherlv_35, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_9_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4640:6: ( (lv_operator_36_0= '.min' ) )
                            // InternalSpectra.g:4641:7: (lv_operator_36_0= '.min' )
                            {
                            // InternalSpectra.g:4641:7: (lv_operator_36_0= '.min' )
                            // InternalSpectra.g:4642:8: lv_operator_36_0= '.min'
                            {
                            lv_operator_36_0=(Token)match(input,95,FOLLOW_2); 

                            								newLeafNode(lv_operator_36_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorMinKeyword_2_1_9_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_36_0, ".min");
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 11 :
                            // InternalSpectra.g:4656:5: ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) )
                            {
                            // InternalSpectra.g:4656:5: ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) )
                            // InternalSpectra.g:4657:6: ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) )
                            {
                            // InternalSpectra.g:4657:6: ( (otherlv_37= RULE_ID ) )
                            // InternalSpectra.g:4658:7: (otherlv_37= RULE_ID )
                            {
                            // InternalSpectra.g:4658:7: (otherlv_37= RULE_ID )
                            // InternalSpectra.g:4659:8: otherlv_37= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            							
                            otherlv_37=(Token)match(input,RULE_ID,FOLLOW_64); 

                            								newLeafNode(otherlv_37, grammarAccess.getTemporalPrimaryExprAccess().getPointerReferrableCrossReference_2_1_10_0_0());
                            							

                            }


                            }

                            // InternalSpectra.g:4670:6: ( (lv_operator_38_0= '.max' ) )
                            // InternalSpectra.g:4671:7: (lv_operator_38_0= '.max' )
                            {
                            // InternalSpectra.g:4671:7: (lv_operator_38_0= '.max' )
                            // InternalSpectra.g:4672:8: lv_operator_38_0= '.max'
                            {
                            lv_operator_38_0=(Token)match(input,96,FOLLOW_2); 

                            								newLeafNode(lv_operator_38_0, grammarAccess.getTemporalPrimaryExprAccess().getOperatorMaxKeyword_2_1_10_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getTemporalPrimaryExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_38_0, ".max");
                            							

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalPrimaryExpr"


    // $ANTLR start "entryRuleSubrange"
    // InternalSpectra.g:4691:1: entryRuleSubrange returns [EObject current=null] : iv_ruleSubrange= ruleSubrange EOF ;
    public final EObject entryRuleSubrange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrange = null;


        try {
            // InternalSpectra.g:4691:49: (iv_ruleSubrange= ruleSubrange EOF )
            // InternalSpectra.g:4692:2: iv_ruleSubrange= ruleSubrange EOF
            {
             newCompositeNode(grammarAccess.getSubrangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubrange=ruleSubrange();

            state._fsp--;

             current =iv_ruleSubrange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubrange"


    // $ANTLR start "ruleSubrange"
    // InternalSpectra.g:4698:1: ruleSubrange returns [EObject current=null] : ( ( (lv_from_0_0= ruleSizeDefineDecl ) ) otherlv_1= '..' ( (lv_to_2_0= ruleSizeDefineDecl ) ) ) ;
    public final EObject ruleSubrange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_from_0_0 = null;

        EObject lv_to_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:4704:2: ( ( ( (lv_from_0_0= ruleSizeDefineDecl ) ) otherlv_1= '..' ( (lv_to_2_0= ruleSizeDefineDecl ) ) ) )
            // InternalSpectra.g:4705:2: ( ( (lv_from_0_0= ruleSizeDefineDecl ) ) otherlv_1= '..' ( (lv_to_2_0= ruleSizeDefineDecl ) ) )
            {
            // InternalSpectra.g:4705:2: ( ( (lv_from_0_0= ruleSizeDefineDecl ) ) otherlv_1= '..' ( (lv_to_2_0= ruleSizeDefineDecl ) ) )
            // InternalSpectra.g:4706:3: ( (lv_from_0_0= ruleSizeDefineDecl ) ) otherlv_1= '..' ( (lv_to_2_0= ruleSizeDefineDecl ) )
            {
            // InternalSpectra.g:4706:3: ( (lv_from_0_0= ruleSizeDefineDecl ) )
            // InternalSpectra.g:4707:4: (lv_from_0_0= ruleSizeDefineDecl )
            {
            // InternalSpectra.g:4707:4: (lv_from_0_0= ruleSizeDefineDecl )
            // InternalSpectra.g:4708:5: lv_from_0_0= ruleSizeDefineDecl
            {

            					newCompositeNode(grammarAccess.getSubrangeAccess().getFromSizeDefineDeclParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_65);
            lv_from_0_0=ruleSizeDefineDecl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubrangeRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_0_0,
            						"tau.smlab.syntech.Spectra.SizeDefineDecl");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,97,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSubrangeAccess().getFullStopFullStopKeyword_1());
            		
            // InternalSpectra.g:4729:3: ( (lv_to_2_0= ruleSizeDefineDecl ) )
            // InternalSpectra.g:4730:4: (lv_to_2_0= ruleSizeDefineDecl )
            {
            // InternalSpectra.g:4730:4: (lv_to_2_0= ruleSizeDefineDecl )
            // InternalSpectra.g:4731:5: lv_to_2_0= ruleSizeDefineDecl
            {

            					newCompositeNode(grammarAccess.getSubrangeAccess().getToSizeDefineDeclParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_to_2_0=ruleSizeDefineDecl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubrangeRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_2_0,
            						"tau.smlab.syntech.Spectra.SizeDefineDecl");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubrange"


    // $ANTLR start "entryRuleConstant"
    // InternalSpectra.g:4752:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSpectra.g:4752:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSpectra.g:4753:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalSpectra.g:4759:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_1_0=null;
        Token lv_booleanValue_2_0=null;
        Token lv_booleanValue_3_0=null;
        Token lv_booleanValue_4_0=null;
        Token lv_integerValue_5_0=null;


        	enterRule();

        try {
            // InternalSpectra.g:4765:2: ( ( () ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) ) ) )
            // InternalSpectra.g:4766:2: ( () ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) ) )
            {
            // InternalSpectra.g:4766:2: ( () ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) ) )
            // InternalSpectra.g:4767:3: () ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) )
            {
            // InternalSpectra.g:4767:3: ()
            // InternalSpectra.g:4768:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSpectra.g:4774:3: ( ( (lv_booleanValue_1_0= 'FALSE' ) ) | ( (lv_booleanValue_2_0= 'false' ) ) | ( (lv_booleanValue_3_0= 'TRUE' ) ) | ( (lv_booleanValue_4_0= 'true' ) ) | ( (lv_integerValue_5_0= RULE_INT ) ) )
            int alt92=5;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt92=1;
                }
                break;
            case 99:
                {
                alt92=2;
                }
                break;
            case 100:
                {
                alt92=3;
                }
                break;
            case 101:
                {
                alt92=4;
                }
                break;
            case RULE_INT:
                {
                alt92=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalSpectra.g:4775:4: ( (lv_booleanValue_1_0= 'FALSE' ) )
                    {
                    // InternalSpectra.g:4775:4: ( (lv_booleanValue_1_0= 'FALSE' ) )
                    // InternalSpectra.g:4776:5: (lv_booleanValue_1_0= 'FALSE' )
                    {
                    // InternalSpectra.g:4776:5: (lv_booleanValue_1_0= 'FALSE' )
                    // InternalSpectra.g:4777:6: lv_booleanValue_1_0= 'FALSE'
                    {
                    lv_booleanValue_1_0=(Token)match(input,98,FOLLOW_2); 

                    						newLeafNode(lv_booleanValue_1_0, grammarAccess.getConstantAccess().getBooleanValueFALSEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "booleanValue", lv_booleanValue_1_0, "FALSE");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:4790:4: ( (lv_booleanValue_2_0= 'false' ) )
                    {
                    // InternalSpectra.g:4790:4: ( (lv_booleanValue_2_0= 'false' ) )
                    // InternalSpectra.g:4791:5: (lv_booleanValue_2_0= 'false' )
                    {
                    // InternalSpectra.g:4791:5: (lv_booleanValue_2_0= 'false' )
                    // InternalSpectra.g:4792:6: lv_booleanValue_2_0= 'false'
                    {
                    lv_booleanValue_2_0=(Token)match(input,99,FOLLOW_2); 

                    						newLeafNode(lv_booleanValue_2_0, grammarAccess.getConstantAccess().getBooleanValueFalseKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "booleanValue", lv_booleanValue_2_0, "false");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:4805:4: ( (lv_booleanValue_3_0= 'TRUE' ) )
                    {
                    // InternalSpectra.g:4805:4: ( (lv_booleanValue_3_0= 'TRUE' ) )
                    // InternalSpectra.g:4806:5: (lv_booleanValue_3_0= 'TRUE' )
                    {
                    // InternalSpectra.g:4806:5: (lv_booleanValue_3_0= 'TRUE' )
                    // InternalSpectra.g:4807:6: lv_booleanValue_3_0= 'TRUE'
                    {
                    lv_booleanValue_3_0=(Token)match(input,100,FOLLOW_2); 

                    						newLeafNode(lv_booleanValue_3_0, grammarAccess.getConstantAccess().getBooleanValueTRUEKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "booleanValue", lv_booleanValue_3_0, "TRUE");
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSpectra.g:4820:4: ( (lv_booleanValue_4_0= 'true' ) )
                    {
                    // InternalSpectra.g:4820:4: ( (lv_booleanValue_4_0= 'true' ) )
                    // InternalSpectra.g:4821:5: (lv_booleanValue_4_0= 'true' )
                    {
                    // InternalSpectra.g:4821:5: (lv_booleanValue_4_0= 'true' )
                    // InternalSpectra.g:4822:6: lv_booleanValue_4_0= 'true'
                    {
                    lv_booleanValue_4_0=(Token)match(input,101,FOLLOW_2); 

                    						newLeafNode(lv_booleanValue_4_0, grammarAccess.getConstantAccess().getBooleanValueTrueKeyword_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "booleanValue", lv_booleanValue_4_0, "true");
                    					

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSpectra.g:4835:4: ( (lv_integerValue_5_0= RULE_INT ) )
                    {
                    // InternalSpectra.g:4835:4: ( (lv_integerValue_5_0= RULE_INT ) )
                    // InternalSpectra.g:4836:5: (lv_integerValue_5_0= RULE_INT )
                    {
                    // InternalSpectra.g:4836:5: (lv_integerValue_5_0= RULE_INT )
                    // InternalSpectra.g:4837:6: lv_integerValue_5_0= RULE_INT
                    {
                    lv_integerValue_5_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_integerValue_5_0, grammarAccess.getConstantAccess().getIntegerValueINTTerminalRuleCall_1_4_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"integerValue",
                    							lv_integerValue_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleTrigger"
    // InternalSpectra.g:4858:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalSpectra.g:4858:48: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalSpectra.g:4859:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // InternalSpectra.g:4865:1: ruleTrigger returns [EObject current=null] : ( () otherlv_1= 'trig' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) ) otherlv_4= '|=>' ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) ) ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_initRegExp_3_0 = null;

        EObject lv_effectRegExp_6_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:4871:2: ( ( () otherlv_1= 'trig' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) ) otherlv_4= '|=>' ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) ) ) )
            // InternalSpectra.g:4872:2: ( () otherlv_1= 'trig' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) ) otherlv_4= '|=>' ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) ) )
            {
            // InternalSpectra.g:4872:2: ( () otherlv_1= 'trig' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) ) otherlv_4= '|=>' ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) ) )
            // InternalSpectra.g:4873:3: () otherlv_1= 'trig' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) ) otherlv_4= '|=>' ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) )
            {
            // InternalSpectra.g:4873:3: ()
            // InternalSpectra.g:4874:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTriggerAccess().getTriggerAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,102,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getTriggerAccess().getTrigKeyword_1());
            		
            // InternalSpectra.g:4884:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_initRegExp_3_0= ruleRegExp ) ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_ID) ) {
                alt93=1;
            }
            else if ( (LA93_0==21||LA93_0==28||LA93_0==48||(LA93_0>=98 && LA93_0<=101)||LA93_0==105) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalSpectra.g:4885:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSpectra.g:4885:4: ( (otherlv_2= RULE_ID ) )
                    // InternalSpectra.g:4886:5: (otherlv_2= RULE_ID )
                    {
                    // InternalSpectra.g:4886:5: (otherlv_2= RULE_ID )
                    // InternalSpectra.g:4887:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_66); 

                    						newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getInitPointerDefineRegExpDeclCrossReference_2_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:4899:4: ( (lv_initRegExp_3_0= ruleRegExp ) )
                    {
                    // InternalSpectra.g:4899:4: ( (lv_initRegExp_3_0= ruleRegExp ) )
                    // InternalSpectra.g:4900:5: (lv_initRegExp_3_0= ruleRegExp )
                    {
                    // InternalSpectra.g:4900:5: (lv_initRegExp_3_0= ruleRegExp )
                    // InternalSpectra.g:4901:6: lv_initRegExp_3_0= ruleRegExp
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getInitRegExpRegExpParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_initRegExp_3_0=ruleRegExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"initRegExp",
                    							lv_initRegExp_3_0,
                    							"tau.smlab.syntech.Spectra.RegExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,103,FOLLOW_44); 

            			newLeafNode(otherlv_4, grammarAccess.getTriggerAccess().getVerticalLineEqualsSignGreaterThanSignKeyword_3());
            		
            // InternalSpectra.g:4923:3: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_effectRegExp_6_0= ruleRegExp ) ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID) ) {
                alt94=1;
            }
            else if ( (LA94_0==21||LA94_0==28||LA94_0==48||(LA94_0>=98 && LA94_0<=101)||LA94_0==105) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalSpectra.g:4924:4: ( (otherlv_5= RULE_ID ) )
                    {
                    // InternalSpectra.g:4924:4: ( (otherlv_5= RULE_ID ) )
                    // InternalSpectra.g:4925:5: (otherlv_5= RULE_ID )
                    {
                    // InternalSpectra.g:4925:5: (otherlv_5= RULE_ID )
                    // InternalSpectra.g:4926:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_5, grammarAccess.getTriggerAccess().getEffectPointerDefineRegExpDeclCrossReference_4_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:4938:4: ( (lv_effectRegExp_6_0= ruleRegExp ) )
                    {
                    // InternalSpectra.g:4938:4: ( (lv_effectRegExp_6_0= ruleRegExp ) )
                    // InternalSpectra.g:4939:5: (lv_effectRegExp_6_0= ruleRegExp )
                    {
                    // InternalSpectra.g:4939:5: (lv_effectRegExp_6_0= ruleRegExp )
                    // InternalSpectra.g:4940:6: lv_effectRegExp_6_0= ruleRegExp
                    {

                    						newCompositeNode(grammarAccess.getTriggerAccess().getEffectRegExpRegExpParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_effectRegExp_6_0=ruleRegExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggerRule());
                    						}
                    						set(
                    							current,
                    							"effectRegExp",
                    							lv_effectRegExp_6_0,
                    							"tau.smlab.syntech.Spectra.RegExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleRegExp"
    // InternalSpectra.g:4962:1: entryRuleRegExp returns [EObject current=null] : iv_ruleRegExp= ruleRegExp EOF ;
    public final EObject entryRuleRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegExp = null;


        try {
            // InternalSpectra.g:4962:47: (iv_ruleRegExp= ruleRegExp EOF )
            // InternalSpectra.g:4963:2: iv_ruleRegExp= ruleRegExp EOF
            {
             newCompositeNode(grammarAccess.getRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegExp=ruleRegExp();

            state._fsp--;

             current =iv_ruleRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegExp"


    // $ANTLR start "ruleRegExp"
    // InternalSpectra.g:4969:1: ruleRegExp returns [EObject current=null] : this_BinaryRegExp_0= ruleBinaryRegExp ;
    public final EObject ruleRegExp() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryRegExp_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:4975:2: (this_BinaryRegExp_0= ruleBinaryRegExp )
            // InternalSpectra.g:4976:2: this_BinaryRegExp_0= ruleBinaryRegExp
            {

            		newCompositeNode(grammarAccess.getRegExpAccess().getBinaryRegExpParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BinaryRegExp_0=ruleBinaryRegExp();

            state._fsp--;


            		current = this_BinaryRegExp_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegExp"


    // $ANTLR start "entryRuleBinaryRegExp"
    // InternalSpectra.g:4987:1: entryRuleBinaryRegExp returns [EObject current=null] : iv_ruleBinaryRegExp= ruleBinaryRegExp EOF ;
    public final EObject entryRuleBinaryRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryRegExp = null;


        try {
            // InternalSpectra.g:4987:53: (iv_ruleBinaryRegExp= ruleBinaryRegExp EOF )
            // InternalSpectra.g:4988:2: iv_ruleBinaryRegExp= ruleBinaryRegExp EOF
            {
             newCompositeNode(grammarAccess.getBinaryRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryRegExp=ruleBinaryRegExp();

            state._fsp--;

             current =iv_ruleBinaryRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryRegExp"


    // $ANTLR start "ruleBinaryRegExp"
    // InternalSpectra.g:4994:1: ruleBinaryRegExp returns [EObject current=null] : (this_UnaryRegExp_0= ruleUnaryRegExp ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )* ) ;
    public final EObject ruleBinaryRegExp() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_UnaryRegExp_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5000:2: ( (this_UnaryRegExp_0= ruleUnaryRegExp ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )* ) )
            // InternalSpectra.g:5001:2: (this_UnaryRegExp_0= ruleUnaryRegExp ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )* )
            {
            // InternalSpectra.g:5001:2: (this_UnaryRegExp_0= ruleUnaryRegExp ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )* )
            // InternalSpectra.g:5002:3: this_UnaryRegExp_0= ruleUnaryRegExp ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getBinaryRegExpAccess().getUnaryRegExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_67);
            this_UnaryRegExp_0=ruleUnaryRegExp();

            state._fsp--;


            			current = this_UnaryRegExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:5010:3: ( () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==21||LA97_0==28||LA97_0==48||LA97_0==64||LA97_0==67||(LA97_0>=98 && LA97_0<=101)||LA97_0==105) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalSpectra.g:5011:4: () ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )? ( (lv_right_3_0= ruleUnaryRegExp ) )
            	    {
            	    // InternalSpectra.g:5011:4: ()
            	    // InternalSpectra.g:5012:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getBinaryRegExpAccess().getBinaryRegExpLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSpectra.g:5018:4: ( ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) ) )?
            	    int alt96=2;
            	    int LA96_0 = input.LA(1);

            	    if ( (LA96_0==64||LA96_0==67) ) {
            	        alt96=1;
            	    }
            	    switch (alt96) {
            	        case 1 :
            	            // InternalSpectra.g:5019:5: ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) )
            	            {
            	            // InternalSpectra.g:5019:5: ( (lv_op_2_1= '&' | lv_op_2_2= '|' ) )
            	            // InternalSpectra.g:5020:6: (lv_op_2_1= '&' | lv_op_2_2= '|' )
            	            {
            	            // InternalSpectra.g:5020:6: (lv_op_2_1= '&' | lv_op_2_2= '|' )
            	            int alt95=2;
            	            int LA95_0 = input.LA(1);

            	            if ( (LA95_0==67) ) {
            	                alt95=1;
            	            }
            	            else if ( (LA95_0==64) ) {
            	                alt95=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 95, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt95) {
            	                case 1 :
            	                    // InternalSpectra.g:5021:7: lv_op_2_1= '&'
            	                    {
            	                    lv_op_2_1=(Token)match(input,67,FOLLOW_25); 

            	                    							newLeafNode(lv_op_2_1, grammarAccess.getBinaryRegExpAccess().getOpAmpersandKeyword_1_1_0_0());
            	                    						

            	                    							if (current==null) {
            	                    								current = createModelElement(grammarAccess.getBinaryRegExpRule());
            	                    							}
            	                    							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	                    						

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalSpectra.g:5032:7: lv_op_2_2= '|'
            	                    {
            	                    lv_op_2_2=(Token)match(input,64,FOLLOW_25); 

            	                    							newLeafNode(lv_op_2_2, grammarAccess.getBinaryRegExpAccess().getOpVerticalLineKeyword_1_1_0_1());
            	                    						

            	                    							if (current==null) {
            	                    								current = createModelElement(grammarAccess.getBinaryRegExpRule());
            	                    							}
            	                    							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	                    						

            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalSpectra.g:5045:4: ( (lv_right_3_0= ruleUnaryRegExp ) )
            	    // InternalSpectra.g:5046:5: (lv_right_3_0= ruleUnaryRegExp )
            	    {
            	    // InternalSpectra.g:5046:5: (lv_right_3_0= ruleUnaryRegExp )
            	    // InternalSpectra.g:5047:6: lv_right_3_0= ruleUnaryRegExp
            	    {

            	    						newCompositeNode(grammarAccess.getBinaryRegExpAccess().getRightUnaryRegExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_67);
            	    lv_right_3_0=ruleUnaryRegExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBinaryRegExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"tau.smlab.syntech.Spectra.UnaryRegExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryRegExp"


    // $ANTLR start "entryRuleUnaryRegExp"
    // InternalSpectra.g:5069:1: entryRuleUnaryRegExp returns [EObject current=null] : iv_ruleUnaryRegExp= ruleUnaryRegExp EOF ;
    public final EObject entryRuleUnaryRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryRegExp = null;


        try {
            // InternalSpectra.g:5069:52: (iv_ruleUnaryRegExp= ruleUnaryRegExp EOF )
            // InternalSpectra.g:5070:2: iv_ruleUnaryRegExp= ruleUnaryRegExp EOF
            {
             newCompositeNode(grammarAccess.getUnaryRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryRegExp=ruleUnaryRegExp();

            state._fsp--;

             current =iv_ruleUnaryRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryRegExp"


    // $ANTLR start "ruleUnaryRegExp"
    // InternalSpectra.g:5076:1: ruleUnaryRegExp returns [EObject current=null] : (this_CompRegExp_0= ruleCompRegExp ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )? ) ;
    public final EObject ruleUnaryRegExp() throws RecognitionException {
        EObject current = null;

        Token lv_kleened_2_0=null;
        Token lv_questionMark_3_0=null;
        Token lv_plus_4_0=null;
        Token lv_haveExactRepetition_5_0=null;
        Token lv_exactRepetition_6_0=null;
        Token otherlv_7=null;
        Token lv_haveAtLeast_8_0=null;
        Token lv_atLeast_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_haveRange_12_0=null;
        Token lv_from_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_to_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        EObject this_CompRegExp_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5082:2: ( (this_CompRegExp_0= ruleCompRegExp ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )? ) )
            // InternalSpectra.g:5083:2: (this_CompRegExp_0= ruleCompRegExp ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )? )
            {
            // InternalSpectra.g:5083:2: (this_CompRegExp_0= ruleCompRegExp ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )? )
            // InternalSpectra.g:5084:3: this_CompRegExp_0= ruleCompRegExp ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )?
            {

            			newCompositeNode(grammarAccess.getUnaryRegExpAccess().getCompRegExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_68);
            this_CompRegExp_0=ruleCompRegExp();

            state._fsp--;


            			current = this_CompRegExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSpectra.g:5092:3: ( () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==23||(LA101_0>=76 && LA101_0<=77)||LA101_0==104) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalSpectra.g:5093:4: () ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) )
                    {
                    // InternalSpectra.g:5093:4: ()
                    // InternalSpectra.g:5094:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getUnaryRegExpAccess().getUnaryRegExpLeftAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:5100:4: ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) )
                    int alt100=6;
                    alt100 = dfa100.predict(input);
                    switch (alt100) {
                        case 1 :
                            // InternalSpectra.g:5101:5: ( (lv_kleened_2_0= '*' ) )
                            {
                            // InternalSpectra.g:5101:5: ( (lv_kleened_2_0= '*' ) )
                            // InternalSpectra.g:5102:6: (lv_kleened_2_0= '*' )
                            {
                            // InternalSpectra.g:5102:6: (lv_kleened_2_0= '*' )
                            // InternalSpectra.g:5103:7: lv_kleened_2_0= '*'
                            {
                            lv_kleened_2_0=(Token)match(input,77,FOLLOW_2); 

                            							newLeafNode(lv_kleened_2_0, grammarAccess.getUnaryRegExpAccess().getKleenedAsteriskKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            							}
                            							setWithLastConsumed(current, "kleened", lv_kleened_2_0 != null, "*");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:5116:5: ( (lv_questionMark_3_0= '?' ) )
                            {
                            // InternalSpectra.g:5116:5: ( (lv_questionMark_3_0= '?' ) )
                            // InternalSpectra.g:5117:6: (lv_questionMark_3_0= '?' )
                            {
                            // InternalSpectra.g:5117:6: (lv_questionMark_3_0= '?' )
                            // InternalSpectra.g:5118:7: lv_questionMark_3_0= '?'
                            {
                            lv_questionMark_3_0=(Token)match(input,104,FOLLOW_2); 

                            							newLeafNode(lv_questionMark_3_0, grammarAccess.getUnaryRegExpAccess().getQuestionMarkQuestionMarkKeyword_1_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            							}
                            							setWithLastConsumed(current, "questionMark", lv_questionMark_3_0 != null, "?");
                            						

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:5131:5: ( (lv_plus_4_0= '+' ) )
                            {
                            // InternalSpectra.g:5131:5: ( (lv_plus_4_0= '+' ) )
                            // InternalSpectra.g:5132:6: (lv_plus_4_0= '+' )
                            {
                            // InternalSpectra.g:5132:6: (lv_plus_4_0= '+' )
                            // InternalSpectra.g:5133:7: lv_plus_4_0= '+'
                            {
                            lv_plus_4_0=(Token)match(input,76,FOLLOW_2); 

                            							newLeafNode(lv_plus_4_0, grammarAccess.getUnaryRegExpAccess().getPlusPlusSignKeyword_1_1_2_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            							}
                            							setWithLastConsumed(current, "plus", lv_plus_4_0 != null, "+");
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:5146:5: ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' )
                            {
                            // InternalSpectra.g:5146:5: ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' )
                            // InternalSpectra.g:5147:6: ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}'
                            {
                            // InternalSpectra.g:5147:6: ( (lv_haveExactRepetition_5_0= '{' ) )
                            // InternalSpectra.g:5148:7: (lv_haveExactRepetition_5_0= '{' )
                            {
                            // InternalSpectra.g:5148:7: (lv_haveExactRepetition_5_0= '{' )
                            // InternalSpectra.g:5149:8: lv_haveExactRepetition_5_0= '{'
                            {
                            lv_haveExactRepetition_5_0=(Token)match(input,23,FOLLOW_11); 

                            								newLeafNode(lv_haveExactRepetition_5_0, grammarAccess.getUnaryRegExpAccess().getHaveExactRepetitionLeftCurlyBracketKeyword_1_1_3_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            								}
                            								setWithLastConsumed(current, "haveExactRepetition", lv_haveExactRepetition_5_0 != null, "{");
                            							

                            }


                            }

                            // InternalSpectra.g:5161:6: ( (lv_exactRepetition_6_0= RULE_INT ) )
                            // InternalSpectra.g:5162:7: (lv_exactRepetition_6_0= RULE_INT )
                            {
                            // InternalSpectra.g:5162:7: (lv_exactRepetition_6_0= RULE_INT )
                            // InternalSpectra.g:5163:8: lv_exactRepetition_6_0= RULE_INT
                            {
                            lv_exactRepetition_6_0=(Token)match(input,RULE_INT,FOLLOW_37); 

                            								newLeafNode(lv_exactRepetition_6_0, grammarAccess.getUnaryRegExpAccess().getExactRepetitionINTTerminalRuleCall_1_1_3_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"exactRepetition",
                            									lv_exactRepetition_6_0,
                            									"org.eclipse.xtext.common.Terminals.INT");
                            							

                            }


                            }

                            otherlv_7=(Token)match(input,25,FOLLOW_2); 

                            						newLeafNode(otherlv_7, grammarAccess.getUnaryRegExpAccess().getRightCurlyBracketKeyword_1_1_3_2());
                            					

                            }


                            }
                            break;
                        case 5 :
                            // InternalSpectra.g:5185:5: ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' )
                            {
                            // InternalSpectra.g:5185:5: ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' )
                            // InternalSpectra.g:5186:6: ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}'
                            {
                            // InternalSpectra.g:5186:6: ( (lv_haveAtLeast_8_0= '{' ) )
                            // InternalSpectra.g:5187:7: (lv_haveAtLeast_8_0= '{' )
                            {
                            // InternalSpectra.g:5187:7: (lv_haveAtLeast_8_0= '{' )
                            // InternalSpectra.g:5188:8: lv_haveAtLeast_8_0= '{'
                            {
                            lv_haveAtLeast_8_0=(Token)match(input,23,FOLLOW_11); 

                            								newLeafNode(lv_haveAtLeast_8_0, grammarAccess.getUnaryRegExpAccess().getHaveAtLeastLeftCurlyBracketKeyword_1_1_4_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            								}
                            								setWithLastConsumed(current, "haveAtLeast", lv_haveAtLeast_8_0 != null, "{");
                            							

                            }


                            }

                            // InternalSpectra.g:5200:6: ( (lv_atLeast_9_0= RULE_INT ) )
                            // InternalSpectra.g:5201:7: (lv_atLeast_9_0= RULE_INT )
                            {
                            // InternalSpectra.g:5201:7: (lv_atLeast_9_0= RULE_INT )
                            // InternalSpectra.g:5202:8: lv_atLeast_9_0= RULE_INT
                            {
                            lv_atLeast_9_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                            								newLeafNode(lv_atLeast_9_0, grammarAccess.getUnaryRegExpAccess().getAtLeastINTTerminalRuleCall_1_1_4_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"atLeast",
                            									lv_atLeast_9_0,
                            									"org.eclipse.xtext.common.Terminals.INT");
                            							

                            }


                            }

                            otherlv_10=(Token)match(input,24,FOLLOW_37); 

                            						newLeafNode(otherlv_10, grammarAccess.getUnaryRegExpAccess().getCommaKeyword_1_1_4_2());
                            					
                            otherlv_11=(Token)match(input,25,FOLLOW_2); 

                            						newLeafNode(otherlv_11, grammarAccess.getUnaryRegExpAccess().getRightCurlyBracketKeyword_1_1_4_3());
                            					

                            }


                            }
                            break;
                        case 6 :
                            // InternalSpectra.g:5228:5: ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' )
                            {
                            // InternalSpectra.g:5228:5: ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' )
                            // InternalSpectra.g:5229:6: ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}'
                            {
                            // InternalSpectra.g:5229:6: ( (lv_haveRange_12_0= '{' ) )
                            // InternalSpectra.g:5230:7: (lv_haveRange_12_0= '{' )
                            {
                            // InternalSpectra.g:5230:7: (lv_haveRange_12_0= '{' )
                            // InternalSpectra.g:5231:8: lv_haveRange_12_0= '{'
                            {
                            lv_haveRange_12_0=(Token)match(input,23,FOLLOW_39); 

                            								newLeafNode(lv_haveRange_12_0, grammarAccess.getUnaryRegExpAccess().getHaveRangeLeftCurlyBracketKeyword_1_1_5_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUnaryRegExpRule());
                            								}
                            								setWithLastConsumed(current, "haveRange", lv_haveRange_12_0 != null, "{");
                            							

                            }


                            }

                            // InternalSpectra.g:5243:6: ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) )
                            int alt98=2;
                            int LA98_0 = input.LA(1);

                            if ( (LA98_0==RULE_INT) ) {
                                alt98=1;
                            }
                            else if ( (LA98_0==RULE_ID) ) {
                                alt98=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 98, 0, input);

                                throw nvae;
                            }
                            switch (alt98) {
                                case 1 :
                                    // InternalSpectra.g:5244:7: ( (lv_from_13_0= RULE_INT ) )
                                    {
                                    // InternalSpectra.g:5244:7: ( (lv_from_13_0= RULE_INT ) )
                                    // InternalSpectra.g:5245:8: (lv_from_13_0= RULE_INT )
                                    {
                                    // InternalSpectra.g:5245:8: (lv_from_13_0= RULE_INT )
                                    // InternalSpectra.g:5246:9: lv_from_13_0= RULE_INT
                                    {
                                    lv_from_13_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                                    									newLeafNode(lv_from_13_0, grammarAccess.getUnaryRegExpAccess().getFromINTTerminalRuleCall_1_1_5_1_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getUnaryRegExpRule());
                                    									}
                                    									setWithLastConsumed(
                                    										current,
                                    										"from",
                                    										lv_from_13_0,
                                    										"org.eclipse.xtext.common.Terminals.INT");
                                    								

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:5263:7: ( (otherlv_14= RULE_ID ) )
                                    {
                                    // InternalSpectra.g:5263:7: ( (otherlv_14= RULE_ID ) )
                                    // InternalSpectra.g:5264:8: (otherlv_14= RULE_ID )
                                    {
                                    // InternalSpectra.g:5264:8: (otherlv_14= RULE_ID )
                                    // InternalSpectra.g:5265:9: otherlv_14= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getUnaryRegExpRule());
                                    									}
                                    								
                                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_69); 

                                    									newLeafNode(otherlv_14, grammarAccess.getUnaryRegExpAccess().getFromDefineDefineDeclCrossReference_1_1_5_1_1_0());
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_15=(Token)match(input,24,FOLLOW_39); 

                            						newLeafNode(otherlv_15, grammarAccess.getUnaryRegExpAccess().getCommaKeyword_1_1_5_2());
                            					
                            // InternalSpectra.g:5281:6: ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) )
                            int alt99=2;
                            int LA99_0 = input.LA(1);

                            if ( (LA99_0==RULE_INT) ) {
                                alt99=1;
                            }
                            else if ( (LA99_0==RULE_ID) ) {
                                alt99=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 99, 0, input);

                                throw nvae;
                            }
                            switch (alt99) {
                                case 1 :
                                    // InternalSpectra.g:5282:7: ( (lv_to_16_0= RULE_INT ) )
                                    {
                                    // InternalSpectra.g:5282:7: ( (lv_to_16_0= RULE_INT ) )
                                    // InternalSpectra.g:5283:8: (lv_to_16_0= RULE_INT )
                                    {
                                    // InternalSpectra.g:5283:8: (lv_to_16_0= RULE_INT )
                                    // InternalSpectra.g:5284:9: lv_to_16_0= RULE_INT
                                    {
                                    lv_to_16_0=(Token)match(input,RULE_INT,FOLLOW_37); 

                                    									newLeafNode(lv_to_16_0, grammarAccess.getUnaryRegExpAccess().getToINTTerminalRuleCall_1_1_5_3_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getUnaryRegExpRule());
                                    									}
                                    									setWithLastConsumed(
                                    										current,
                                    										"to",
                                    										lv_to_16_0,
                                    										"org.eclipse.xtext.common.Terminals.INT");
                                    								

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSpectra.g:5301:7: ( (otherlv_17= RULE_ID ) )
                                    {
                                    // InternalSpectra.g:5301:7: ( (otherlv_17= RULE_ID ) )
                                    // InternalSpectra.g:5302:8: (otherlv_17= RULE_ID )
                                    {
                                    // InternalSpectra.g:5302:8: (otherlv_17= RULE_ID )
                                    // InternalSpectra.g:5303:9: otherlv_17= RULE_ID
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getUnaryRegExpRule());
                                    									}
                                    								
                                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_37); 

                                    									newLeafNode(otherlv_17, grammarAccess.getUnaryRegExpAccess().getToDefineDefineDeclCrossReference_1_1_5_3_1_0());
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_18=(Token)match(input,25,FOLLOW_2); 

                            						newLeafNode(otherlv_18, grammarAccess.getUnaryRegExpAccess().getRightCurlyBracketKeyword_1_1_5_4());
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryRegExp"


    // $ANTLR start "entryRuleCompRegExp"
    // InternalSpectra.g:5326:1: entryRuleCompRegExp returns [EObject current=null] : iv_ruleCompRegExp= ruleCompRegExp EOF ;
    public final EObject entryRuleCompRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompRegExp = null;


        try {
            // InternalSpectra.g:5326:51: (iv_ruleCompRegExp= ruleCompRegExp EOF )
            // InternalSpectra.g:5327:2: iv_ruleCompRegExp= ruleCompRegExp EOF
            {
             newCompositeNode(grammarAccess.getCompRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompRegExp=ruleCompRegExp();

            state._fsp--;

             current =iv_ruleCompRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompRegExp"


    // $ANTLR start "ruleCompRegExp"
    // InternalSpectra.g:5333:1: ruleCompRegExp returns [EObject current=null] : (this_PrimaryRegExp_0= rulePrimaryRegExp | ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) ) ) ;
    public final EObject ruleCompRegExp() throws RecognitionException {
        EObject current = null;

        Token lv_comp_2_0=null;
        EObject this_PrimaryRegExp_0 = null;

        EObject lv_left_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5339:2: ( (this_PrimaryRegExp_0= rulePrimaryRegExp | ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) ) ) )
            // InternalSpectra.g:5340:2: (this_PrimaryRegExp_0= rulePrimaryRegExp | ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) ) )
            {
            // InternalSpectra.g:5340:2: (this_PrimaryRegExp_0= rulePrimaryRegExp | ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==21||LA102_0==28||LA102_0==48||(LA102_0>=98 && LA102_0<=101)) ) {
                alt102=1;
            }
            else if ( (LA102_0==105) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalSpectra.g:5341:3: this_PrimaryRegExp_0= rulePrimaryRegExp
                    {

                    			newCompositeNode(grammarAccess.getCompRegExpAccess().getPrimaryRegExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryRegExp_0=rulePrimaryRegExp();

                    state._fsp--;


                    			current = this_PrimaryRegExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:5350:3: ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) )
                    {
                    // InternalSpectra.g:5350:3: ( () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) ) )
                    // InternalSpectra.g:5351:4: () ( (lv_comp_2_0= '~' ) ) ( (lv_left_3_0= ruleCompRegExp ) )
                    {
                    // InternalSpectra.g:5351:4: ()
                    // InternalSpectra.g:5352:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getCompRegExpAccess().getCompRegExpAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:5358:4: ( (lv_comp_2_0= '~' ) )
                    // InternalSpectra.g:5359:5: (lv_comp_2_0= '~' )
                    {
                    // InternalSpectra.g:5359:5: (lv_comp_2_0= '~' )
                    // InternalSpectra.g:5360:6: lv_comp_2_0= '~'
                    {
                    lv_comp_2_0=(Token)match(input,105,FOLLOW_25); 

                    						newLeafNode(lv_comp_2_0, grammarAccess.getCompRegExpAccess().getCompTildeKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCompRegExpRule());
                    						}
                    						setWithLastConsumed(current, "comp", lv_comp_2_0, "~");
                    					

                    }


                    }

                    // InternalSpectra.g:5372:4: ( (lv_left_3_0= ruleCompRegExp ) )
                    // InternalSpectra.g:5373:5: (lv_left_3_0= ruleCompRegExp )
                    {
                    // InternalSpectra.g:5373:5: (lv_left_3_0= ruleCompRegExp )
                    // InternalSpectra.g:5374:6: lv_left_3_0= ruleCompRegExp
                    {

                    						newCompositeNode(grammarAccess.getCompRegExpAccess().getLeftCompRegExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_left_3_0=ruleCompRegExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompRegExpRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_3_0,
                    							"tau.smlab.syntech.Spectra.CompRegExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompRegExp"


    // $ANTLR start "entryRulePrimaryRegExp"
    // InternalSpectra.g:5396:1: entryRulePrimaryRegExp returns [EObject current=null] : iv_rulePrimaryRegExp= rulePrimaryRegExp EOF ;
    public final EObject entryRulePrimaryRegExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryRegExp = null;


        try {
            // InternalSpectra.g:5396:54: (iv_rulePrimaryRegExp= rulePrimaryRegExp EOF )
            // InternalSpectra.g:5397:2: iv_rulePrimaryRegExp= rulePrimaryRegExp EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRegExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryRegExp=rulePrimaryRegExp();

            state._fsp--;

             current =iv_rulePrimaryRegExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryRegExp"


    // $ANTLR start "rulePrimaryRegExp"
    // InternalSpectra.g:5403:1: rulePrimaryRegExp returns [EObject current=null] : ( (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' ) | ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) ) | ( (lv_assrt_4_0= ruleBooleanTerm ) ) | ( (lv_empty_5_0= '()' ) ) ) ;
    public final EObject rulePrimaryRegExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_1=null;
        Token lv_val_3_2=null;
        Token lv_val_3_3=null;
        Token lv_val_3_4=null;
        Token lv_empty_5_0=null;
        EObject this_RegExp_1 = null;

        EObject lv_assrt_4_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5409:2: ( ( (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' ) | ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) ) | ( (lv_assrt_4_0= ruleBooleanTerm ) ) | ( (lv_empty_5_0= '()' ) ) ) )
            // InternalSpectra.g:5410:2: ( (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' ) | ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) ) | ( (lv_assrt_4_0= ruleBooleanTerm ) ) | ( (lv_empty_5_0= '()' ) ) )
            {
            // InternalSpectra.g:5410:2: ( (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' ) | ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) ) | ( (lv_assrt_4_0= ruleBooleanTerm ) ) | ( (lv_empty_5_0= '()' ) ) )
            int alt104=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt104=1;
                }
                break;
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt104=2;
                }
                break;
            case 21:
                {
                alt104=3;
                }
                break;
            case 48:
                {
                alt104=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalSpectra.g:5411:3: (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' )
                    {
                    // InternalSpectra.g:5411:3: (otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')' )
                    // InternalSpectra.g:5412:4: otherlv_0= '(' this_RegExp_1= ruleRegExp otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,28,FOLLOW_25); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryRegExpAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryRegExpAccess().getRegExpParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_28);
                    this_RegExp_1=ruleRegExp();

                    state._fsp--;


                    				current = this_RegExp_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,29,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryRegExpAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:5430:3: ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) )
                    {
                    // InternalSpectra.g:5430:3: ( ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) ) )
                    // InternalSpectra.g:5431:4: ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) )
                    {
                    // InternalSpectra.g:5431:4: ( (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' ) )
                    // InternalSpectra.g:5432:5: (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' )
                    {
                    // InternalSpectra.g:5432:5: (lv_val_3_1= 'TRUE' | lv_val_3_2= 'FALSE' | lv_val_3_3= 'true' | lv_val_3_4= 'false' )
                    int alt103=4;
                    switch ( input.LA(1) ) {
                    case 100:
                        {
                        alt103=1;
                        }
                        break;
                    case 98:
                        {
                        alt103=2;
                        }
                        break;
                    case 101:
                        {
                        alt103=3;
                        }
                        break;
                    case 99:
                        {
                        alt103=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 103, 0, input);

                        throw nvae;
                    }

                    switch (alt103) {
                        case 1 :
                            // InternalSpectra.g:5433:6: lv_val_3_1= 'TRUE'
                            {
                            lv_val_3_1=(Token)match(input,100,FOLLOW_2); 

                            						newLeafNode(lv_val_3_1, grammarAccess.getPrimaryRegExpAccess().getValTRUEKeyword_1_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPrimaryRegExpRule());
                            						}
                            						setWithLastConsumed(current, "val", lv_val_3_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:5444:6: lv_val_3_2= 'FALSE'
                            {
                            lv_val_3_2=(Token)match(input,98,FOLLOW_2); 

                            						newLeafNode(lv_val_3_2, grammarAccess.getPrimaryRegExpAccess().getValFALSEKeyword_1_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPrimaryRegExpRule());
                            						}
                            						setWithLastConsumed(current, "val", lv_val_3_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:5455:6: lv_val_3_3= 'true'
                            {
                            lv_val_3_3=(Token)match(input,101,FOLLOW_2); 

                            						newLeafNode(lv_val_3_3, grammarAccess.getPrimaryRegExpAccess().getValTrueKeyword_1_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPrimaryRegExpRule());
                            						}
                            						setWithLastConsumed(current, "val", lv_val_3_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:5466:6: lv_val_3_4= 'false'
                            {
                            lv_val_3_4=(Token)match(input,99,FOLLOW_2); 

                            						newLeafNode(lv_val_3_4, grammarAccess.getPrimaryRegExpAccess().getValFalseKeyword_1_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPrimaryRegExpRule());
                            						}
                            						setWithLastConsumed(current, "val", lv_val_3_4, null);
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:5480:3: ( (lv_assrt_4_0= ruleBooleanTerm ) )
                    {
                    // InternalSpectra.g:5480:3: ( (lv_assrt_4_0= ruleBooleanTerm ) )
                    // InternalSpectra.g:5481:4: (lv_assrt_4_0= ruleBooleanTerm )
                    {
                    // InternalSpectra.g:5481:4: (lv_assrt_4_0= ruleBooleanTerm )
                    // InternalSpectra.g:5482:5: lv_assrt_4_0= ruleBooleanTerm
                    {

                    					newCompositeNode(grammarAccess.getPrimaryRegExpAccess().getAssrtBooleanTermParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_assrt_4_0=ruleBooleanTerm();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryRegExpRule());
                    					}
                    					set(
                    						current,
                    						"assrt",
                    						lv_assrt_4_0,
                    						"tau.smlab.syntech.Spectra.BooleanTerm");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSpectra.g:5500:3: ( (lv_empty_5_0= '()' ) )
                    {
                    // InternalSpectra.g:5500:3: ( (lv_empty_5_0= '()' ) )
                    // InternalSpectra.g:5501:4: (lv_empty_5_0= '()' )
                    {
                    // InternalSpectra.g:5501:4: (lv_empty_5_0= '()' )
                    // InternalSpectra.g:5502:5: lv_empty_5_0= '()'
                    {
                    lv_empty_5_0=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_empty_5_0, grammarAccess.getPrimaryRegExpAccess().getEmptyLeftParenthesisRightParenthesisKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimaryRegExpRule());
                    					}
                    					setWithLastConsumed(current, "empty", lv_empty_5_0 != null, "()");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryRegExp"


    // $ANTLR start "entryRuleBooleanTerm"
    // InternalSpectra.g:5518:1: entryRuleBooleanTerm returns [EObject current=null] : iv_ruleBooleanTerm= ruleBooleanTerm EOF ;
    public final EObject entryRuleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTerm = null;


        try {
            // InternalSpectra.g:5518:52: (iv_ruleBooleanTerm= ruleBooleanTerm EOF )
            // InternalSpectra.g:5519:2: iv_ruleBooleanTerm= ruleBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanTerm=ruleBooleanTerm();

            state._fsp--;

             current =iv_ruleBooleanTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanTerm"


    // $ANTLR start "ruleBooleanTerm"
    // InternalSpectra.g:5525:1: ruleBooleanTerm returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_relExpr_2_0= ruleTemporalInExpr ) ) otherlv_3= ']' ) ;
    public final EObject ruleBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_relExpr_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5531:2: ( ( () otherlv_1= '[' ( (lv_relExpr_2_0= ruleTemporalInExpr ) ) otherlv_3= ']' ) )
            // InternalSpectra.g:5532:2: ( () otherlv_1= '[' ( (lv_relExpr_2_0= ruleTemporalInExpr ) ) otherlv_3= ']' )
            {
            // InternalSpectra.g:5532:2: ( () otherlv_1= '[' ( (lv_relExpr_2_0= ruleTemporalInExpr ) ) otherlv_3= ']' )
            // InternalSpectra.g:5533:3: () otherlv_1= '[' ( (lv_relExpr_2_0= ruleTemporalInExpr ) ) otherlv_3= ']'
            {
            // InternalSpectra.g:5533:3: ()
            // InternalSpectra.g:5534:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTermAccess().getBooleanTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanTermAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSpectra.g:5544:3: ( (lv_relExpr_2_0= ruleTemporalInExpr ) )
            // InternalSpectra.g:5545:4: (lv_relExpr_2_0= ruleTemporalInExpr )
            {
            // InternalSpectra.g:5545:4: (lv_relExpr_2_0= ruleTemporalInExpr )
            // InternalSpectra.g:5546:5: lv_relExpr_2_0= ruleTemporalInExpr
            {

            					newCompositeNode(grammarAccess.getBooleanTermAccess().getRelExprTemporalInExprParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_relExpr_2_0=ruleTemporalInExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanTermRule());
            					}
            					set(
            						current,
            						"relExpr",
            						lv_relExpr_2_0,
            						"tau.smlab.syntech.Spectra.TemporalInExpr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getBooleanTermAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanTerm"


    // $ANTLR start "entryRuleValueInRange"
    // InternalSpectra.g:5571:1: entryRuleValueInRange returns [EObject current=null] : iv_ruleValueInRange= ruleValueInRange EOF ;
    public final EObject entryRuleValueInRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueInRange = null;


        try {
            // InternalSpectra.g:5571:53: (iv_ruleValueInRange= ruleValueInRange EOF )
            // InternalSpectra.g:5572:2: iv_ruleValueInRange= ruleValueInRange EOF
            {
             newCompositeNode(grammarAccess.getValueInRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueInRange=ruleValueInRange();

            state._fsp--;

             current =iv_ruleValueInRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueInRange"


    // $ANTLR start "ruleValueInRange"
    // InternalSpectra.g:5578:1: ruleValueInRange returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_int_1_0= RULE_INT ) ) | ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) ) | ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) ) ) ;
    public final EObject ruleValueInRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_int_1_0=null;
        Token lv_from_2_0=null;
        Token lv_multi_3_0=null;
        Token lv_to_4_0=null;
        Token lv_booleanValue_5_1=null;
        Token lv_booleanValue_5_2=null;
        Token lv_booleanValue_5_3=null;
        Token lv_booleanValue_5_4=null;


        	enterRule();

        try {
            // InternalSpectra.g:5584:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_int_1_0= RULE_INT ) ) | ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) ) | ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) ) ) )
            // InternalSpectra.g:5585:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_int_1_0= RULE_INT ) ) | ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) ) | ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) ) )
            {
            // InternalSpectra.g:5585:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_int_1_0= RULE_INT ) ) | ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) ) | ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt106=1;
                }
                break;
            case RULE_INT:
                {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==16) ) {
                    alt106=3;
                }
                else if ( (LA106_2==EOF||(LA106_2>=24 && LA106_2<=25)) ) {
                    alt106=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 2, input);

                    throw nvae;
                }
                }
                break;
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt106=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // InternalSpectra.g:5586:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalSpectra.g:5586:3: ( (otherlv_0= RULE_ID ) )
                    // InternalSpectra.g:5587:4: (otherlv_0= RULE_ID )
                    {
                    // InternalSpectra.g:5587:4: (otherlv_0= RULE_ID )
                    // InternalSpectra.g:5588:5: otherlv_0= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getValueInRangeRule());
                    					}
                    				
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_0, grammarAccess.getValueInRangeAccess().getConstTypeConstantCrossReference_0_0());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:5600:3: ( (lv_int_1_0= RULE_INT ) )
                    {
                    // InternalSpectra.g:5600:3: ( (lv_int_1_0= RULE_INT ) )
                    // InternalSpectra.g:5601:4: (lv_int_1_0= RULE_INT )
                    {
                    // InternalSpectra.g:5601:4: (lv_int_1_0= RULE_INT )
                    // InternalSpectra.g:5602:5: lv_int_1_0= RULE_INT
                    {
                    lv_int_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_int_1_0, grammarAccess.getValueInRangeAccess().getIntINTTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getValueInRangeRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"int",
                    						lv_int_1_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:5619:3: ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) )
                    {
                    // InternalSpectra.g:5619:3: ( ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) ) )
                    // InternalSpectra.g:5620:4: ( (lv_from_2_0= RULE_INT ) ) ( (lv_multi_3_0= '-' ) ) ( (lv_to_4_0= RULE_INT ) )
                    {
                    // InternalSpectra.g:5620:4: ( (lv_from_2_0= RULE_INT ) )
                    // InternalSpectra.g:5621:5: (lv_from_2_0= RULE_INT )
                    {
                    // InternalSpectra.g:5621:5: (lv_from_2_0= RULE_INT )
                    // InternalSpectra.g:5622:6: lv_from_2_0= RULE_INT
                    {
                    lv_from_2_0=(Token)match(input,RULE_INT,FOLLOW_70); 

                    						newLeafNode(lv_from_2_0, grammarAccess.getValueInRangeAccess().getFromINTTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueInRangeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"from",
                    							lv_from_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalSpectra.g:5638:4: ( (lv_multi_3_0= '-' ) )
                    // InternalSpectra.g:5639:5: (lv_multi_3_0= '-' )
                    {
                    // InternalSpectra.g:5639:5: (lv_multi_3_0= '-' )
                    // InternalSpectra.g:5640:6: lv_multi_3_0= '-'
                    {
                    lv_multi_3_0=(Token)match(input,16,FOLLOW_11); 

                    						newLeafNode(lv_multi_3_0, grammarAccess.getValueInRangeAccess().getMultiHyphenMinusKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueInRangeRule());
                    						}
                    						setWithLastConsumed(current, "multi", lv_multi_3_0 != null, "-");
                    					

                    }


                    }

                    // InternalSpectra.g:5652:4: ( (lv_to_4_0= RULE_INT ) )
                    // InternalSpectra.g:5653:5: (lv_to_4_0= RULE_INT )
                    {
                    // InternalSpectra.g:5653:5: (lv_to_4_0= RULE_INT )
                    // InternalSpectra.g:5654:6: lv_to_4_0= RULE_INT
                    {
                    lv_to_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_to_4_0, grammarAccess.getValueInRangeAccess().getToINTTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueInRangeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"to",
                    							lv_to_4_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSpectra.g:5672:3: ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) )
                    {
                    // InternalSpectra.g:5672:3: ( ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) ) )
                    // InternalSpectra.g:5673:4: ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) )
                    {
                    // InternalSpectra.g:5673:4: ( (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' ) )
                    // InternalSpectra.g:5674:5: (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' )
                    {
                    // InternalSpectra.g:5674:5: (lv_booleanValue_5_1= 'TRUE' | lv_booleanValue_5_2= 'FALSE' | lv_booleanValue_5_3= 'true' | lv_booleanValue_5_4= 'false' )
                    int alt105=4;
                    switch ( input.LA(1) ) {
                    case 100:
                        {
                        alt105=1;
                        }
                        break;
                    case 98:
                        {
                        alt105=2;
                        }
                        break;
                    case 101:
                        {
                        alt105=3;
                        }
                        break;
                    case 99:
                        {
                        alt105=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 105, 0, input);

                        throw nvae;
                    }

                    switch (alt105) {
                        case 1 :
                            // InternalSpectra.g:5675:6: lv_booleanValue_5_1= 'TRUE'
                            {
                            lv_booleanValue_5_1=(Token)match(input,100,FOLLOW_2); 

                            						newLeafNode(lv_booleanValue_5_1, grammarAccess.getValueInRangeAccess().getBooleanValueTRUEKeyword_3_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getValueInRangeRule());
                            						}
                            						setWithLastConsumed(current, "booleanValue", lv_booleanValue_5_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:5686:6: lv_booleanValue_5_2= 'FALSE'
                            {
                            lv_booleanValue_5_2=(Token)match(input,98,FOLLOW_2); 

                            						newLeafNode(lv_booleanValue_5_2, grammarAccess.getValueInRangeAccess().getBooleanValueFALSEKeyword_3_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getValueInRangeRule());
                            						}
                            						setWithLastConsumed(current, "booleanValue", lv_booleanValue_5_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalSpectra.g:5697:6: lv_booleanValue_5_3= 'true'
                            {
                            lv_booleanValue_5_3=(Token)match(input,101,FOLLOW_2); 

                            						newLeafNode(lv_booleanValue_5_3, grammarAccess.getValueInRangeAccess().getBooleanValueTrueKeyword_3_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getValueInRangeRule());
                            						}
                            						setWithLastConsumed(current, "booleanValue", lv_booleanValue_5_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalSpectra.g:5708:6: lv_booleanValue_5_4= 'false'
                            {
                            lv_booleanValue_5_4=(Token)match(input,99,FOLLOW_2); 

                            						newLeafNode(lv_booleanValue_5_4, grammarAccess.getValueInRangeAccess().getBooleanValueFalseKeyword_3_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getValueInRangeRule());
                            						}
                            						setWithLastConsumed(current, "booleanValue", lv_booleanValue_5_4, null);
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueInRange"


    // $ANTLR start "entryRuleQuantifierExpr"
    // InternalSpectra.g:5725:1: entryRuleQuantifierExpr returns [EObject current=null] : iv_ruleQuantifierExpr= ruleQuantifierExpr EOF ;
    public final EObject entryRuleQuantifierExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifierExpr = null;


        try {
            // InternalSpectra.g:5725:55: (iv_ruleQuantifierExpr= ruleQuantifierExpr EOF )
            // InternalSpectra.g:5726:2: iv_ruleQuantifierExpr= ruleQuantifierExpr EOF
            {
             newCompositeNode(grammarAccess.getQuantifierExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantifierExpr=ruleQuantifierExpr();

            state._fsp--;

             current =iv_ruleQuantifierExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantifierExpr"


    // $ANTLR start "ruleQuantifierExpr"
    // InternalSpectra.g:5732:1: ruleQuantifierExpr returns [EObject current=null] : (this_TemporalInExpr_0= ruleTemporalInExpr | ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) ) ) ;
    public final EObject ruleQuantifierExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token otherlv_4=null;
        EObject this_TemporalInExpr_0 = null;

        EObject lv_domainVar_3_0 = null;

        EObject lv_temporalExpr_5_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5738:2: ( (this_TemporalInExpr_0= ruleTemporalInExpr | ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) ) ) )
            // InternalSpectra.g:5739:2: (this_TemporalInExpr_0= ruleTemporalInExpr | ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) ) )
            {
            // InternalSpectra.g:5739:2: (this_TemporalInExpr_0= ruleTemporalInExpr | ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==RULE_ID||LA108_0==RULE_INT||LA108_0==16||LA108_0==26||LA108_0==28||(LA108_0>=83 && LA108_0<=90)||(LA108_0>=98 && LA108_0<=101)) ) {
                alt108=1;
            }
            else if ( ((LA108_0>=106 && LA108_0<=107)) ) {
                alt108=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // InternalSpectra.g:5740:3: this_TemporalInExpr_0= ruleTemporalInExpr
                    {

                    			newCompositeNode(grammarAccess.getQuantifierExprAccess().getTemporalInExprParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalInExpr_0=ruleTemporalInExpr();

                    state._fsp--;


                    			current = this_TemporalInExpr_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSpectra.g:5749:3: ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) )
                    {
                    // InternalSpectra.g:5749:3: ( () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) ) )
                    // InternalSpectra.g:5750:4: () ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) )
                    {
                    // InternalSpectra.g:5750:4: ()
                    // InternalSpectra.g:5751:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuantifierExprAccess().getQuantifierExprAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSpectra.g:5757:4: ( ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) ) )
                    // InternalSpectra.g:5758:5: ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) ) ( (lv_domainVar_3_0= ruleDomainVarDecl ) ) otherlv_4= '.' ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) )
                    {
                    // InternalSpectra.g:5758:5: ( ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) ) )
                    // InternalSpectra.g:5759:6: ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) )
                    {
                    // InternalSpectra.g:5759:6: ( (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' ) )
                    // InternalSpectra.g:5760:7: (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' )
                    {
                    // InternalSpectra.g:5760:7: (lv_operator_2_1= 'forall' | lv_operator_2_2= 'exists' )
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==106) ) {
                        alt107=1;
                    }
                    else if ( (LA107_0==107) ) {
                        alt107=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalSpectra.g:5761:8: lv_operator_2_1= 'forall'
                            {
                            lv_operator_2_1=(Token)match(input,106,FOLLOW_4); 

                            								newLeafNode(lv_operator_2_1, grammarAccess.getQuantifierExprAccess().getOperatorForallKeyword_1_1_0_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getQuantifierExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                            							

                            }
                            break;
                        case 2 :
                            // InternalSpectra.g:5772:8: lv_operator_2_2= 'exists'
                            {
                            lv_operator_2_2=(Token)match(input,107,FOLLOW_4); 

                            								newLeafNode(lv_operator_2_2, grammarAccess.getQuantifierExprAccess().getOperatorExistsKeyword_1_1_0_0_1());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getQuantifierExprRule());
                            								}
                            								setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                            							

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpectra.g:5785:5: ( (lv_domainVar_3_0= ruleDomainVarDecl ) )
                    // InternalSpectra.g:5786:6: (lv_domainVar_3_0= ruleDomainVarDecl )
                    {
                    // InternalSpectra.g:5786:6: (lv_domainVar_3_0= ruleDomainVarDecl )
                    // InternalSpectra.g:5787:7: lv_domainVar_3_0= ruleDomainVarDecl
                    {

                    							newCompositeNode(grammarAccess.getQuantifierExprAccess().getDomainVarDomainVarDeclParserRuleCall_1_1_1_0());
                    						
                    pushFollow(FOLLOW_71);
                    lv_domainVar_3_0=ruleDomainVarDecl();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getQuantifierExprRule());
                    							}
                    							set(
                    								current,
                    								"domainVar",
                    								lv_domainVar_3_0,
                    								"tau.smlab.syntech.Spectra.DomainVarDecl");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,108,FOLLOW_18); 

                    					newLeafNode(otherlv_4, grammarAccess.getQuantifierExprAccess().getFullStopKeyword_1_1_2());
                    				
                    // InternalSpectra.g:5808:5: ( (lv_temporalExpr_5_0= ruleQuantifierExpr ) )
                    // InternalSpectra.g:5809:6: (lv_temporalExpr_5_0= ruleQuantifierExpr )
                    {
                    // InternalSpectra.g:5809:6: (lv_temporalExpr_5_0= ruleQuantifierExpr )
                    // InternalSpectra.g:5810:7: lv_temporalExpr_5_0= ruleQuantifierExpr
                    {

                    							newCompositeNode(grammarAccess.getQuantifierExprAccess().getTemporalExprQuantifierExprParserRuleCall_1_1_3_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_temporalExpr_5_0=ruleQuantifierExpr();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getQuantifierExprRule());
                    							}
                    							set(
                    								current,
                    								"temporalExpr",
                    								lv_temporalExpr_5_0,
                    								"tau.smlab.syntech.Spectra.QuantifierExpr");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantifierExpr"


    // $ANTLR start "entryRuleDomainVarDecl"
    // InternalSpectra.g:5833:1: entryRuleDomainVarDecl returns [EObject current=null] : iv_ruleDomainVarDecl= ruleDomainVarDecl EOF ;
    public final EObject entryRuleDomainVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainVarDecl = null;


        try {
            // InternalSpectra.g:5833:54: (iv_ruleDomainVarDecl= ruleDomainVarDecl EOF )
            // InternalSpectra.g:5834:2: iv_ruleDomainVarDecl= ruleDomainVarDecl EOF
            {
             newCompositeNode(grammarAccess.getDomainVarDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainVarDecl=ruleDomainVarDecl();

            state._fsp--;

             current =iv_ruleDomainVarDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainVarDecl"


    // $ANTLR start "ruleDomainVarDecl"
    // InternalSpectra.g:5840:1: ruleDomainVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_domainType_2_0= ruleVarType ) ) ) ;
    public final EObject ruleDomainVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_domainType_2_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5846:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_domainType_2_0= ruleVarType ) ) ) )
            // InternalSpectra.g:5847:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_domainType_2_0= ruleVarType ) ) )
            {
            // InternalSpectra.g:5847:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_domainType_2_0= ruleVarType ) ) )
            // InternalSpectra.g:5848:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_domainType_2_0= ruleVarType ) )
            {
            // InternalSpectra.g:5848:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpectra.g:5849:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSpectra.g:5849:4: (lv_name_0_0= RULE_ID )
            // InternalSpectra.g:5850:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDomainVarDeclAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDomainVarDeclRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,59,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getDomainVarDeclAccess().getInKeyword_1());
            		
            // InternalSpectra.g:5870:3: ( (lv_domainType_2_0= ruleVarType ) )
            // InternalSpectra.g:5871:4: (lv_domainType_2_0= ruleVarType )
            {
            // InternalSpectra.g:5871:4: (lv_domainType_2_0= ruleVarType )
            // InternalSpectra.g:5872:5: lv_domainType_2_0= ruleVarType
            {

            					newCompositeNode(grammarAccess.getDomainVarDeclAccess().getDomainTypeVarTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_domainType_2_0=ruleVarType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDomainVarDeclRule());
            					}
            					set(
            						current,
            						"domainType",
            						lv_domainType_2_0,
            						"tau.smlab.syntech.Spectra.VarType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainVarDecl"


    // $ANTLR start "entryRuleSizeDefineDecl"
    // InternalSpectra.g:5893:1: entryRuleSizeDefineDecl returns [EObject current=null] : iv_ruleSizeDefineDecl= ruleSizeDefineDecl EOF ;
    public final EObject entryRuleSizeDefineDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizeDefineDecl = null;


        try {
            // InternalSpectra.g:5893:55: (iv_ruleSizeDefineDecl= ruleSizeDefineDecl EOF )
            // InternalSpectra.g:5894:2: iv_ruleSizeDefineDecl= ruleSizeDefineDecl EOF
            {
             newCompositeNode(grammarAccess.getSizeDefineDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizeDefineDecl=ruleSizeDefineDecl();

            state._fsp--;

             current =iv_ruleSizeDefineDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSizeDefineDecl"


    // $ANTLR start "ruleSizeDefineDecl"
    // InternalSpectra.g:5900:1: ruleSizeDefineDecl returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) | ( (otherlv_1= RULE_ID ) ) | (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' ) ) ;
    public final EObject ruleSizeDefineDecl() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_arithExp_3_0 = null;



        	enterRule();

        try {
            // InternalSpectra.g:5906:2: ( ( ( (lv_value_0_0= RULE_INT ) ) | ( (otherlv_1= RULE_ID ) ) | (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' ) ) )
            // InternalSpectra.g:5907:2: ( ( (lv_value_0_0= RULE_INT ) ) | ( (otherlv_1= RULE_ID ) ) | (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' ) )
            {
            // InternalSpectra.g:5907:2: ( ( (lv_value_0_0= RULE_INT ) ) | ( (otherlv_1= RULE_ID ) ) | (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' ) )
            int alt109=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt109=1;
                }
                break;
            case RULE_ID:
                {
                alt109=2;
                }
                break;
            case 28:
                {
                alt109=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalSpectra.g:5908:3: ( (lv_value_0_0= RULE_INT ) )
                    {
                    // InternalSpectra.g:5908:3: ( (lv_value_0_0= RULE_INT ) )
                    // InternalSpectra.g:5909:4: (lv_value_0_0= RULE_INT )
                    {
                    // InternalSpectra.g:5909:4: (lv_value_0_0= RULE_INT )
                    // InternalSpectra.g:5910:5: lv_value_0_0= RULE_INT
                    {
                    lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_value_0_0, grammarAccess.getSizeDefineDeclAccess().getValueINTTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSizeDefineDeclRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:5927:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalSpectra.g:5927:3: ( (otherlv_1= RULE_ID ) )
                    // InternalSpectra.g:5928:4: (otherlv_1= RULE_ID )
                    {
                    // InternalSpectra.g:5928:4: (otherlv_1= RULE_ID )
                    // InternalSpectra.g:5929:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSizeDefineDeclRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getSizeDefineDeclAccess().getNameDefineDeclCrossReference_1_0());
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:5941:3: (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' )
                    {
                    // InternalSpectra.g:5941:3: (otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')' )
                    // InternalSpectra.g:5942:4: otherlv_2= '(' ( (lv_arithExp_3_0= ruleTemporalExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getSizeDefineDeclAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalSpectra.g:5946:4: ( (lv_arithExp_3_0= ruleTemporalExpression ) )
                    // InternalSpectra.g:5947:5: (lv_arithExp_3_0= ruleTemporalExpression )
                    {
                    // InternalSpectra.g:5947:5: (lv_arithExp_3_0= ruleTemporalExpression )
                    // InternalSpectra.g:5948:6: lv_arithExp_3_0= ruleTemporalExpression
                    {

                    						newCompositeNode(grammarAccess.getSizeDefineDeclAccess().getArithExpTemporalExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_arithExp_3_0=ruleTemporalExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSizeDefineDeclRule());
                    						}
                    						set(
                    							current,
                    							"arithExp",
                    							lv_arithExp_3_0,
                    							"tau.smlab.syntech.Spectra.TemporalExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSizeDefineDeclAccess().getRightParenthesisKeyword_2_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSizeDefineDecl"


    // $ANTLR start "entryRuleTOK_SEMI"
    // InternalSpectra.g:5974:1: entryRuleTOK_SEMI returns [String current=null] : iv_ruleTOK_SEMI= ruleTOK_SEMI EOF ;
    public final String entryRuleTOK_SEMI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTOK_SEMI = null;


        try {
            // InternalSpectra.g:5974:48: (iv_ruleTOK_SEMI= ruleTOK_SEMI EOF )
            // InternalSpectra.g:5975:2: iv_ruleTOK_SEMI= ruleTOK_SEMI EOF
            {
             newCompositeNode(grammarAccess.getTOK_SEMIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTOK_SEMI=ruleTOK_SEMI();

            state._fsp--;

             current =iv_ruleTOK_SEMI.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTOK_SEMI"


    // $ANTLR start "ruleTOK_SEMI"
    // InternalSpectra.g:5981:1: ruleTOK_SEMI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ';' ;
    public final AntlrDatatypeRuleToken ruleTOK_SEMI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSpectra.g:5987:2: (kw= ';' )
            // InternalSpectra.g:5988:2: kw= ';'
            {
            kw=(Token)match(input,109,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getTOK_SEMIAccess().getSemicolonKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTOK_SEMI"


    // $ANTLR start "ruleVarOwner"
    // InternalSpectra.g:5996:1: ruleVarOwner returns [Enumerator current=null] : ( (enumLiteral_0= 'output' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'sysvar' ) | (enumLiteral_3= 'sys' ) | (enumLiteral_4= 'input' ) | (enumLiteral_5= 'in' ) | (enumLiteral_6= 'envvar' ) | (enumLiteral_7= 'env' ) | (enumLiteral_8= 'auxvar' ) | (enumLiteral_9= 'aux' ) ) ;
    public final Enumerator ruleVarOwner() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalSpectra.g:6002:2: ( ( (enumLiteral_0= 'output' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'sysvar' ) | (enumLiteral_3= 'sys' ) | (enumLiteral_4= 'input' ) | (enumLiteral_5= 'in' ) | (enumLiteral_6= 'envvar' ) | (enumLiteral_7= 'env' ) | (enumLiteral_8= 'auxvar' ) | (enumLiteral_9= 'aux' ) ) )
            // InternalSpectra.g:6003:2: ( (enumLiteral_0= 'output' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'sysvar' ) | (enumLiteral_3= 'sys' ) | (enumLiteral_4= 'input' ) | (enumLiteral_5= 'in' ) | (enumLiteral_6= 'envvar' ) | (enumLiteral_7= 'env' ) | (enumLiteral_8= 'auxvar' ) | (enumLiteral_9= 'aux' ) )
            {
            // InternalSpectra.g:6003:2: ( (enumLiteral_0= 'output' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'sysvar' ) | (enumLiteral_3= 'sys' ) | (enumLiteral_4= 'input' ) | (enumLiteral_5= 'in' ) | (enumLiteral_6= 'envvar' ) | (enumLiteral_7= 'env' ) | (enumLiteral_8= 'auxvar' ) | (enumLiteral_9= 'aux' ) )
            int alt110=10;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt110=1;
                }
                break;
            case 111:
                {
                alt110=2;
                }
                break;
            case 112:
                {
                alt110=3;
                }
                break;
            case 113:
                {
                alt110=4;
                }
                break;
            case 114:
                {
                alt110=5;
                }
                break;
            case 59:
                {
                alt110=6;
                }
                break;
            case 115:
                {
                alt110=7;
                }
                break;
            case 116:
                {
                alt110=8;
                }
                break;
            case 117:
                {
                alt110=9;
                }
                break;
            case 118:
                {
                alt110=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalSpectra.g:6004:3: (enumLiteral_0= 'output' )
                    {
                    // InternalSpectra.g:6004:3: (enumLiteral_0= 'output' )
                    // InternalSpectra.g:6005:4: enumLiteral_0= 'output'
                    {
                    enumLiteral_0=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:6012:3: (enumLiteral_1= 'out' )
                    {
                    // InternalSpectra.g:6012:3: (enumLiteral_1= 'out' )
                    // InternalSpectra.g:6013:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:6020:3: (enumLiteral_2= 'sysvar' )
                    {
                    // InternalSpectra.g:6020:3: (enumLiteral_2= 'sysvar' )
                    // InternalSpectra.g:6021:4: enumLiteral_2= 'sysvar'
                    {
                    enumLiteral_2=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSpectra.g:6028:3: (enumLiteral_3= 'sys' )
                    {
                    // InternalSpectra.g:6028:3: (enumLiteral_3= 'sys' )
                    // InternalSpectra.g:6029:4: enumLiteral_3= 'sys'
                    {
                    enumLiteral_3=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getVarOwnerAccess().getSYSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSpectra.g:6036:3: (enumLiteral_4= 'input' )
                    {
                    // InternalSpectra.g:6036:3: (enumLiteral_4= 'input' )
                    // InternalSpectra.g:6037:4: enumLiteral_4= 'input'
                    {
                    enumLiteral_4=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSpectra.g:6044:3: (enumLiteral_5= 'in' )
                    {
                    // InternalSpectra.g:6044:3: (enumLiteral_5= 'in' )
                    // InternalSpectra.g:6045:4: enumLiteral_5= 'in'
                    {
                    enumLiteral_5=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSpectra.g:6052:3: (enumLiteral_6= 'envvar' )
                    {
                    // InternalSpectra.g:6052:3: (enumLiteral_6= 'envvar' )
                    // InternalSpectra.g:6053:4: enumLiteral_6= 'envvar'
                    {
                    enumLiteral_6=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalSpectra.g:6060:3: (enumLiteral_7= 'env' )
                    {
                    // InternalSpectra.g:6060:3: (enumLiteral_7= 'env' )
                    // InternalSpectra.g:6061:4: enumLiteral_7= 'env'
                    {
                    enumLiteral_7=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getVarOwnerAccess().getENVEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalSpectra.g:6068:3: (enumLiteral_8= 'auxvar' )
                    {
                    // InternalSpectra.g:6068:3: (enumLiteral_8= 'auxvar' )
                    // InternalSpectra.g:6069:4: enumLiteral_8= 'auxvar'
                    {
                    enumLiteral_8=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getAUXEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getVarOwnerAccess().getAUXEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalSpectra.g:6076:3: (enumLiteral_9= 'aux' )
                    {
                    // InternalSpectra.g:6076:3: (enumLiteral_9= 'aux' )
                    // InternalSpectra.g:6077:4: enumLiteral_9= 'aux'
                    {
                    enumLiteral_9=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getVarOwnerAccess().getAUXEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getVarOwnerAccess().getAUXEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarOwner"


    // $ANTLR start "ruleOverflowMethod"
    // InternalSpectra.g:6087:1: ruleOverflowMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'keep' ) | (enumLiteral_1= 'false' ) | (enumLiteral_2= 'modulo' ) ) ;
    public final Enumerator ruleOverflowMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSpectra.g:6093:2: ( ( (enumLiteral_0= 'keep' ) | (enumLiteral_1= 'false' ) | (enumLiteral_2= 'modulo' ) ) )
            // InternalSpectra.g:6094:2: ( (enumLiteral_0= 'keep' ) | (enumLiteral_1= 'false' ) | (enumLiteral_2= 'modulo' ) )
            {
            // InternalSpectra.g:6094:2: ( (enumLiteral_0= 'keep' ) | (enumLiteral_1= 'false' ) | (enumLiteral_2= 'modulo' ) )
            int alt111=3;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt111=1;
                }
                break;
            case 99:
                {
                alt111=2;
                }
                break;
            case 120:
                {
                alt111=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // InternalSpectra.g:6095:3: (enumLiteral_0= 'keep' )
                    {
                    // InternalSpectra.g:6095:3: (enumLiteral_0= 'keep' )
                    // InternalSpectra.g:6096:4: enumLiteral_0= 'keep'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getOverflowMethodAccess().getKEEPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOverflowMethodAccess().getKEEPEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSpectra.g:6103:3: (enumLiteral_1= 'false' )
                    {
                    // InternalSpectra.g:6103:3: (enumLiteral_1= 'false' )
                    // InternalSpectra.g:6104:4: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getOverflowMethodAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOverflowMethodAccess().getFALSEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSpectra.g:6111:3: (enumLiteral_2= 'modulo' )
                    {
                    // InternalSpectra.g:6111:3: (enumLiteral_2= 'modulo' )
                    // InternalSpectra.g:6112:4: enumLiteral_2= 'modulo'
                    {
                    enumLiteral_2=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getOverflowMethodAccess().getMODULOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOverflowMethodAccess().getMODULOEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverflowMethod"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA100 dfa100 = new DFA100(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\1\16\7\uffff\2\4\4\uffff\1\17\2\uffff\1\4";
    static final String dfa_3s = "\1\166\7\uffff\2\153\4\uffff\1\155\2\uffff\1\153";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\11\1\13\1\14\1\15\1\uffff\1\10\1\12\1\uffff";
    static final String dfa_5s = "\22\uffff}>";
    static final String[] dfa_6s = {
            "\1\7\2\uffff\1\2\1\uffff\1\3\6\uffff\1\14\1\13\7\uffff\1\6\6\uffff\1\5\4\uffff\1\4\3\uffff\1\10\1\11\2\12\2\uffff\1\15\1\uffff\1\1\62\uffff\11\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\17\11\uffff\1\17\11\uffff\1\17\1\uffff\1\17\7\uffff\6\17\2\uffff\3\17\10\uffff\2\20\32\uffff\10\17\7\uffff\5\17\3\uffff\2\17",
            "\1\16\1\uffff\1\17\11\uffff\1\17\11\uffff\1\17\1\uffff\1\17\7\uffff\6\17\2\uffff\3\17\10\uffff\2\20\32\uffff\10\17\7\uffff\5\17\3\uffff\2\17",
            "",
            "",
            "",
            "",
            "\1\21\1\17\1\uffff\1\17\2\uffff\1\17\1\uffff\1\17\4\uffff\1\17\23\uffff\1\17\11\uffff\31\17\10\uffff\6\17\14\uffff\1\17",
            "",
            "",
            "\1\17\1\uffff\1\17\11\uffff\1\17\11\uffff\1\17\1\uffff\1\17\7\uffff\6\17\2\uffff\3\17\10\uffff\2\20\32\uffff\10\17\7\uffff\5\17\3\uffff\2\17"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "206:2: (this_Var_0= ruleVar | this_TypeDef_1= ruleTypeDef | this_Define_2= ruleDefine | this_Predicate_3= rulePredicate | this_Pattern_4= rulePattern | this_Monitor_5= ruleMonitor | this_WeightDef_6= ruleWeightDef | this_LTLGar_7= ruleLTLGar | this_LTLAsm_8= ruleLTLAsm | this_EXGar_9= ruleEXGar | this_Counter_10= ruleCounter | this_DefineRegExp_11= ruleDefineRegExp | this_RegexpTest_12= ruleRegexpTest )";
        }
    }
    static final String dfa_7s = "\15\uffff";
    static final String dfa_8s = "\1\uffff\1\13\13\uffff";
    static final String dfa_9s = "\1\4\1\20\13\uffff";
    static final String dfa_10s = "\1\132\1\155\13\uffff";
    static final String dfa_11s = "\2\uffff\1\2\1\4\1\5\1\7\1\10\1\11\1\12\1\13\1\1\1\3\1\6";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\13\uffff\1\2\11\uffff\1\4\76\uffff\1\2\1\3",
            "\1\13\1\uffff\1\13\2\uffff\2\13\1\uffff\2\13\2\uffff\1\12\1\13\22\uffff\1\12\11\uffff\31\13\10\uffff\1\14\1\5\1\6\1\7\1\10\1\11\14\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "4230:4: ( ( ( (otherlv_5= RULE_ID ) ) ( (otherlv_6= '(' ( (lv_predPattParams_7_0= ruleTemporalInExpr ) ) (otherlv_8= ',' ( (lv_predPattParams_9_0= ruleTemporalInExpr ) ) )* otherlv_10= ')' ) | otherlv_11= '()' ) ) | ( ( ( (lv_operator_12_1= '-' | lv_operator_12_2= '!' ) ) ) ( (lv_tpe_13_0= ruleTemporalPrimaryExpr ) ) ) | ( ( (otherlv_14= RULE_ID ) ) (otherlv_15= '[' ( (lv_index_16_0= ruleTemporalInExpr ) ) otherlv_17= ']' )* ) | ( ( (lv_operator_18_0= 'next' ) ) otherlv_19= '(' ( (lv_temporalExpression_20_0= ruleTemporalInExpr ) ) otherlv_21= ')' ) | ( ( (lv_operator_22_0= 'regexp' ) ) otherlv_23= '(' ( ( (lv_regexp_24_0= ruleRegExp ) ) | ( (otherlv_25= RULE_ID ) ) ) otherlv_26= ')' ) | ( ( (otherlv_27= RULE_ID ) ) ( (lv_operator_28_0= '.all' ) ) ) | ( ( (otherlv_29= RULE_ID ) ) ( (lv_operator_30_0= '.any' ) ) ) | ( ( (otherlv_31= RULE_ID ) ) ( (lv_operator_32_0= '.prod' ) ) ) | ( ( (otherlv_33= RULE_ID ) ) ( (lv_operator_34_0= '.sum' ) ) ) | ( ( (otherlv_35= RULE_ID ) ) ( (lv_operator_36_0= '.min' ) ) ) | ( ( (otherlv_37= RULE_ID ) ) ( (lv_operator_38_0= '.max' ) ) ) )";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\1\27\3\uffff\1\4\1\30\1\uffff\1\4\2\uffff";
    static final String dfa_16s = "\1\150\3\uffff\1\6\1\31\1\uffff\1\31\2\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\6\1\uffff\1\4\1\5";
    static final String dfa_18s = "\12\uffff}>";
    static final String[] dfa_19s = {
            "\1\4\64\uffff\1\3\1\1\32\uffff\1\2",
            "",
            "",
            "",
            "\1\6\1\uffff\1\5",
            "\1\7\1\10",
            "",
            "\1\6\1\uffff\1\6\22\uffff\1\11",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "5100:4: ( ( (lv_kleened_2_0= '*' ) ) | ( (lv_questionMark_3_0= '?' ) ) | ( (lv_plus_4_0= '+' ) ) | ( ( (lv_haveExactRepetition_5_0= '{' ) ) ( (lv_exactRepetition_6_0= RULE_INT ) ) otherlv_7= '}' ) | ( ( (lv_haveAtLeast_8_0= '{' ) ) ( (lv_atLeast_9_0= RULE_INT ) ) otherlv_10= ',' otherlv_11= '}' ) | ( ( (lv_haveRange_12_0= '{' ) ) ( ( (lv_from_13_0= RULE_INT ) ) | ( (otherlv_14= RULE_ID ) ) ) otherlv_15= ',' ( ( (lv_to_16_0= RULE_INT ) ) | ( (otherlv_17= RULE_ID ) ) ) otherlv_18= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0A7884080C0A4000L,0x007FC00000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0A7884080C0A4002L,0x007FC00000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010050L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000014010050L,0x0000003C07F80000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0006000000800010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000014010050L,0x00000C3C07F80000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000050L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000010200000L,0x0000023C00000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000007D6010050L,0x0000003C07F80000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0180000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000003F016010050L,0x0000003C07F80000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00007BF014010050L,0x0000003C07F80000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000073F016010050L,0x0000003C07F80000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x000073F014010050L,0x00000C7C07F80000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0180000000000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000001000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0001000010200010L,0x0000023C00000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000050L,0x0000003C00000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000040002L,0x00000000000003E0L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000010002L,0x0000000000001000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000078000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000014010050L,0x0000003C06000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0001000010200002L,0x0000023C00000009L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000800002L,0x0000010000003000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});

}