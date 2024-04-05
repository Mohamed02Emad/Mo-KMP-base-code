import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        KoinHelperKt.doInitKoin(nativeModule: nil,
        appDeclaration: { _ in }
         )
     }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
